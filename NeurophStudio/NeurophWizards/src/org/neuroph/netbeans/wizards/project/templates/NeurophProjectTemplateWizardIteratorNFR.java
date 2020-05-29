package org.neuroph.netbeans.wizards.project.templates;

import java.awt.Component;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.JComponent;
import javax.swing.event.ChangeListener;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.spi.project.ui.support.ProjectChooser;
import org.netbeans.spi.project.ui.templates.support.Templates;
import org.neuroph.core.Layer;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.Neuron;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.core.transfer.Trapezoid;
import org.neuroph.netbeans.main.easyneurons.samples.NFRSampleTopComponent;
import org.neuroph.netbeans.project.CurrentProject;
import org.neuroph.netbeans.project.NeurophProject;
import org.neuroph.netbeans.project.NeurophProjectFilesFactory;
import org.neuroph.netbeans.visual.NeuralNetAndDataSet;
import org.neuroph.nnet.NeuroFuzzyPerceptron;
import org.openide.WizardDescriptor;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;
import org.openide.xml.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class NeurophProjectTemplateWizardIteratorNFR implements WizardDescriptor./*Progress*/InstantiatingIterator {

    private int index;
    private WizardDescriptor.Panel[] panels;
    private WizardDescriptor wiz;

    public NeurophProjectTemplateWizardIteratorNFR() {
    }

    public static NeurophProjectTemplateWizardIteratorNFR createIterator() {
        return new NeurophProjectTemplateWizardIteratorNFR();
    }

    private WizardDescriptor.Panel[] createPanels() {
        return new WizardDescriptor.Panel[]{
                    new NeurophProjectTemplateWizardPanelNFR(),};
    }

    private String[] createSteps() {
        return new String[]{
                    NbBundle.getMessage(NeurophProjectTemplateWizardIteratorNFR.class, "LBL_CreateProjectStep")
                };
    }

    public Set/*<FileObject>*/ instantiate(/*ProgressHandle handle*/) throws IOException {
        Set<FileObject> resultSet = new LinkedHashSet<FileObject>();
        File dirF = FileUtil.normalizeFile((File) wiz.getProperty("projdir"));
        dirF.mkdirs();

        FileObject template = Templates.getTemplate(wiz);
        FileObject dir = FileUtil.toFileObject(dirF);
        unZipFile(template.getInputStream(), dir);

        // Always open top dir as a project:
        resultSet.add(dir);
        // Look for nested projects to open as well:
        Enumeration<? extends FileObject> e = dir.getFolders(true);
        while (e.hasMoreElements()) {
            FileObject subfolder = e.nextElement();
            if (ProjectManager.getDefault().isProject(subfolder)) {
                resultSet.add(subfolder);
            }
        }

        File parent = dirF.getParentFile();
        if (parent != null && parent.exists()) {
            ProjectChooser.setProjectsFolder(parent);
        }
        NeurophProject np = (NeurophProject) ProjectManager.getDefault().findProject(dir);
        //ProjectChooser.setProjectsFolder(dir);
        CurrentProject.getInstance().setCurrentProject(np);
        nfrSample();
        return resultSet;
     //   return Collections.EMPTY_SET;
    }

    public void initialize(WizardDescriptor wiz) {
        this.wiz = wiz;
        index = 0;
        panels = createPanels();
        // Make sure list of steps is accurate.
        String[] steps = createSteps();
        for (int i = 0; i < panels.length; i++) {
            Component c = panels[i].getComponent();
            if (steps[i] == null) {
                // Default step name to component name of panel.
                // Mainly useful for getting the name of the target
                // chooser to appear in the list of steps.
                steps[i] = c.getName();
            }
            if (c instanceof JComponent) { // assume Swing components
                JComponent jc = (JComponent) c;
                // Step #.
                // TODO if using org.openide.dialogs >= 7.8, can use WizardDescriptor.PROP_*:
                jc.putClientProperty("WizardPanel_contentSelectedIndex", new Integer(i));
                // Step name (actually the whole list for reference).
                jc.putClientProperty("WizardPanel_contentData", steps);
            }
        }
    }

    public void uninitialize(WizardDescriptor wiz) {
        this.wiz.putProperty("projdir", null);
        this.wiz.putProperty("name", null);
        this.wiz = null;
        panels = null;
    }

    public String name() {
        return MessageFormat.format("{0} of {1}",
                new Object[]{new Integer(index + 1), new Integer(panels.length)});
    }

    public boolean hasNext() {
        return index < panels.length - 1;
    }

    public boolean hasPrevious() {
        return index > 0;
    }

    public void nextPanel() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index++;
    }

    public void previousPanel() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        index--;
    }

    public WizardDescriptor.Panel current() {
        return panels[index];
    }

    // If nothing unusual changes in the middle of the wizard, simply:
    public final void addChangeListener(ChangeListener l) {
    }

    public final void removeChangeListener(ChangeListener l) {
    }

    private static void unZipFile(InputStream source, FileObject projectRoot) throws IOException {
        try {
            ZipInputStream str = new ZipInputStream(source);
            ZipEntry entry;
            while ((entry = str.getNextEntry()) != null) {
                if (entry.isDirectory()) {
                    FileUtil.createFolder(projectRoot, entry.getName());
                } else {
                    FileObject fo = FileUtil.createData(projectRoot, entry.getName());
                    if ("nbproject/project.xml".equals(entry.getName())) {
                        // Special handling for setting name of Ant-based projects; customize as needed:
                        filterProjectXML(fo, str, projectRoot.getName());
                    } else {
                        writeFile(str, fo);
                    }
                }
            }
        } finally {
            source.close();
        }
    }

    private static void writeFile(ZipInputStream str, FileObject fo) throws IOException {
        OutputStream out = fo.getOutputStream();
        try {
            FileUtil.copy(str, out);
        } finally {
            out.close();
        }
    }

    private static void filterProjectXML(FileObject fo, ZipInputStream str, String name) throws IOException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            FileUtil.copy(str, baos);
            Document doc = XMLUtil.parse(new InputSource(new ByteArrayInputStream(baos.toByteArray())), false, false, null, null);
            NodeList nl = doc.getDocumentElement().getElementsByTagName("name");
            if (nl != null) {
                for (int i = 0; i < nl.getLength(); i++) {
                    Element el = (Element) nl.item(i);
                    if (el.getParentNode() != null && "data".equals(el.getParentNode().getNodeName())) {
                        NodeList nl2 = el.getChildNodes();
                        if (nl2.getLength() > 0) {
                            nl2.item(0).setNodeValue(name);
                        }
                        break;
                    }
                }
            }
            OutputStream out = fo.getOutputStream();
            try {
                XMLUtil.write(doc, out, "UTF-8");
            } finally {
                out.close();
            }
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
            writeFile(str, fo);
        }

    }
    
  /**
     * Opens NFRSample
     */
    public void nfrSample() {
        double[][] pointsSets = {{0, 0, 20, 22}, // bad
        {20, 22, 40, 42}, // good
        {40, 42, 80, 82}, // very good
        {80, 82, 100, 100}}; // excellent

        double[][] timeSets = {{15, 15, 20, 25}, // fast
        {20, 25, 35, 40}, // moderate
        {35, 40, 1000, 1000}}; // slow

        NeuralNetwork nnet = new NeuroFuzzyPerceptron(pointsSets, timeSets);
        DataSet tSet = new DataSet(2, 4);

        Layer setLayer = nnet.getLayerAt(1);

        int outClass = 0;

        for (int i = 0; i <= 3; i++) { // iterate points sets
            Neuron icell = setLayer.getNeuronAt(i);
            Trapezoid tfi = (Trapezoid) icell.getTransferFunction();
            double r1i = tfi.getRightLow();
            double l2i = tfi.getLeftHigh();
            double r2i = tfi.getRightHigh();
            double right_intersection_i = r2i + (r1i - r2i) / 2;

            for (int j = 6; j >= 4; j--) { // iterate speed sets
                Neuron jcell = setLayer.getNeuronAt(j);
                Trapezoid tfj = (Trapezoid) jcell.getTransferFunction();

                double r1j = tfj.getRightLow();
                double l2j = tfj.getLeftHigh();
                double r2j = tfj.getRightHigh();
                double right_intersection_j = r2j + (r1j - r2j) / 2;

                String outputPattern;
                if (outClass <= 3) {
                    outputPattern = "1 0 0 0";
                } else if ((outClass >= 4) && (outClass <= 6)) {
                    outputPattern = "0 1 0 0";
                } else if ((outClass >= 7) && (outClass <= 9)) {
                    outputPattern = "0 0 1 0";
                } else {
                    outputPattern = "0 0 0 1";
                }

                String inputPattern = Double.toString(l2i) + " "
                        + Double.toString(l2j);
                DataSetRow dataRow = new DataSetRow(
                        inputPattern, outputPattern);
                tSet.add(dataRow);

                inputPattern = Double.toString(l2i) + " "
                        + Double.toString(r2j);
                dataRow = new DataSetRow(inputPattern, outputPattern);
                tSet.add(dataRow);

                inputPattern = Double.toString(l2i) + " "
                        + Double.toString(right_intersection_j);
                dataRow = new DataSetRow(inputPattern, outputPattern);
                tSet.add(dataRow);

                inputPattern = Double.toString(r2i) + " "
                        + Double.toString(l2j);
                dataRow = new DataSetRow(inputPattern, outputPattern);
                tSet.add(dataRow);

                inputPattern = Double.toString(r2i) + " "
                        + Double.toString(r2j);
                dataRow = new DataSetRow(inputPattern, outputPattern);
                tSet.add(dataRow);

                inputPattern = Double.toString(r2i) + " "
                        + Double.toString(right_intersection_j);
                dataRow = new DataSetRow(inputPattern, outputPattern);
                tSet.add(dataRow);

                inputPattern = Double.toString(right_intersection_i) + " "
                        + Double.toString(l2j);
                dataRow = new DataSetRow(inputPattern, outputPattern);
                tSet.add(dataRow);

                inputPattern = Double.toString(right_intersection_i) + " "
                        + Double.toString(r2j);
                dataRow = new DataSetRow(inputPattern, outputPattern);
                tSet.add(dataRow);

                inputPattern = Double.toString(right_intersection_i) + " "
                        + Double.toString(right_intersection_j);
                dataRow = new DataSetRow(inputPattern, outputPattern);
                tSet.add(dataRow);

                outClass++;
            } // for j

        } // for i

        nnet.setLabel("NFR sample");
        tSet.setLabel("NFR tset");

        NeuralNetAndDataSet controller = new NeuralNetAndDataSet(nnet, tSet);

        NeurophProjectFilesFactory.getDefault().createNeuralNetworkFile(nnet);
        NeurophProjectFilesFactory.getDefault().createTrainingSetFile(tSet);

        NFRSampleTopComponent frame = new NFRSampleTopComponent();
        frame.setNeuralNetworkTrainingController(controller);

        frame.open();
        frame.requestActive();
    }    
}
