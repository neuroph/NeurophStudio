package org.neuroph.netbeans.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.neuroph.netbeans.visual.TrainingController;
import org.neuroph.netbeans.visual.NeuralNetAndDataSet;
import org.neuroph.netbeans.main.easyneurons.dialog.HebbianTrainingDialog;
import org.neuroph.netbeans.main.easyneurons.dialog.NewSupervisedTrainingDialog;
import org.neuroph.nnet.Adaline;
import org.neuroph.nnet.ConvolutionalNetwork;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.NeuroFuzzyPerceptron;
import org.neuroph.nnet.Perceptron;
import org.neuroph.nnet.RBFNetwork;
import org.neuroph.nnet.SupervisedHebbianNetwork;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Neuroph",
        id = "org.neuroph.netbeans.toolbar.TrainToolbarAction")
@ActionRegistration(
        iconBase = "org/neuroph/netbeans/toolbar/icons/train.png",
        displayName = "#CTL_TrainToolbarAction")
@ActionReference(path = "Toolbars/Neuroph", position = -800)
@Messages("CTL_TrainToolbarAction=Train")
public final class TrainToolbarAction implements ActionListener {
  
    private final NeuralNetAndDataSet neuralNetAndDataSet;     // morao je da ostane ovaj zbog VisualEditorTopComponent

    public TrainToolbarAction(NeuralNetAndDataSet context) {
        this.neuralNetAndDataSet = context;       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            Class neuralNetClass = neuralNetAndDataSet.getNetwork().getClass();

            if (neuralNetClass.equals(Adaline.class)
                    || neuralNetClass.equals(Perceptron.class)
                    || neuralNetClass.equals(RBFNetwork.class)
                    || neuralNetClass.equals(NeuroFuzzyPerceptron.class)) {
                showLmsTrainingDialog();
            } else if (neuralNetClass.equals(MultiLayerPerceptron.class) ||
                       neuralNetClass.equals(ConvolutionalNetwork.class)) {
                 showLmsTrainingDialog();
            } else if (neuralNetClass.equals(SupervisedHebbianNetwork.class)) {
                showHebbianTrainingDialog();
//            } else if (neuralNetClass.equals(NoPropNet.class)) {                
//                neuralNetAndDataSet.getNetwork().randomizeWeights(new RangeRandomizer(-1, 1));
//                RangeNormalizer norm = new RangeNormalizer(-0.9, 0.9);
//                norm.normalize(neuralNetAndDataSet.getDataSet());
//                neuralNetAndDataSet.getDataSet().shuffle();
//                showLmsTrainingDialog();
            } else {
                TrainingController trainingController = new TrainingController(neuralNetAndDataSet);
                trainingController.train();
            }
    }

    private void showLmsTrainingDialog() {
        NewSupervisedTrainingDialog dialog = new NewSupervisedTrainingDialog(null, true, neuralNetAndDataSet);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void showHebbianTrainingDialog() {
        HebbianTrainingDialog trainingDialog = new HebbianTrainingDialog(null,
                true, this.neuralNetAndDataSet);
        trainingDialog.setLocationRelativeTo(null);
        trainingDialog.setVisible(true);
    }
}
