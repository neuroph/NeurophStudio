package org.neuroph.netbeans.main.easyneurons.dialog;

import org.neuroph.netbeans.main.easyneurons.errorgraph.GraphFrameTopComponent;
import org.neuroph.netbeans.visual.NeuralNetAndDataSet;
import org.neuroph.netbeans.visual.TrainingController;
import org.neuroph.nnet.learning.LMS;
import org.neuroph.nnet.learning.MomentumBackpropagation;

/**
 * New version of SupervisedTrainingDialog
 * added crossval and standard swing
 *
 * @author zoran
 */
public class NewSupervisedTrainingDialog extends javax.swing.JDialog {
     private TrainingController trainingController;

    /**
     * Creates new form BackPropagationTrainingDialog
     */
    public NewSupervisedTrainingDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public NewSupervisedTrainingDialog(java.awt.Frame parent, boolean modal, NeuralNetAndDataSet neuralNetAndDataSet) {
        super(parent, modal);
        this.trainingController = new TrainingController(neuralNetAndDataSet);
        initComponents();

        // todo: we could get NeuralNetAndDataSet from lookup!!!!

        if (neuralNetAndDataSet.getNetwork().getLearningRule() instanceof MomentumBackpropagation) {
            momentumLabel.setEnabled(true);
            momentumField.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        maxErrorField = new javax.swing.JTextField();
        maxIterationsField = new javax.swing.JTextField();
        limitIterationsCheckBox = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        momentumLabel = new javax.swing.JLabel();
        learningRateField = new javax.swing.JTextField();
        momentumField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        trainButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        graphCheckBox = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        deepNettsCheckBox = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        crossValidationCheckBox = new javax.swing.JCheckBox();
        subsetCountField = new javax.swing.JTextField();
        saveNetworksCheckBox = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.title")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.jPanel1.border.title"))); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.jLabel1.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 18, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        maxErrorField.setText(org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.maxErrorField.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 85;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 19, 0, 36);
        jPanel1.add(maxErrorField, gridBagConstraints);

        maxIterationsField.setText(org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.maxIterationsField.text")); // NOI18N
        maxIterationsField.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 85;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 19, 33, 36);
        jPanel1.add(maxIterationsField, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(limitIterationsCheckBox, org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.limitIterationsCheckBox.text")); // NOI18N
        limitIterationsCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                limitIterationsCheckBoxStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 18, 0, 0);
        jPanel1.add(limitIterationsCheckBox, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.jPanel2.border.title"))); // NOI18N
        jPanel2.setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.jLabel3.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 29, 0, 0);
        jPanel2.add(jLabel3, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(momentumLabel, org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.momentumLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 29, 0, 0);
        jPanel2.add(momentumLabel, gridBagConstraints);

        learningRateField.setText(org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.learningRateField.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 84, 0, 45);
        jPanel2.add(learningRateField, gridBagConstraints);

        momentumField.setText(org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.momentumField.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 84, 29, 45);
        jPanel2.add(momentumField, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(trainButton, org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.trainButton.text")); // NOI18N
        trainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 54;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 76, 0, 0);
        jPanel3.add(trainButton, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(closeButton, org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.closeButton.text")); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 56;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 75);
        jPanel3.add(closeButton, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.jPanel4.border.title"))); // NOI18N

        graphCheckBox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(graphCheckBox, org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.graphCheckBox.text")); // NOI18N

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.jLabel5.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(deepNettsCheckBox, org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.deepNettsCheckBox.text")); // NOI18N
        deepNettsCheckBox.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.jLabel4.text")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deepNettsCheckBox)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(graphCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(graphCheckBox)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deepNettsCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.jPanel5.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(crossValidationCheckBox, org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.crossValidationCheckBox.text")); // NOI18N
        crossValidationCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                crossValidationCheckBoxItemStateChanged(evt);
            }
        });

        subsetCountField.setText(org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.subsetCountField.text")); // NOI18N
        subsetCountField.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(saveNetworksCheckBox, org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.saveNetworksCheckBox.text")); // NOI18N
        saveNetworksCheckBox.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(NewSupervisedTrainingDialog.class, "NewSupervisedTrainingDialog.jLabel2.text")); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveNetworksCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crossValidationCheckBox)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(subsetCountField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crossValidationCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subsetCountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveNetworksCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void trainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainButtonActionPerformed
		String learningRateStr = learningRateField.getText().trim();
		String maxErrorStr = maxErrorField.getText().trim();
		String maxIterationsStr = maxIterationsField.getText().trim();
		String momentumStr = momentumField.getText().trim();

		Double learningRate = new Double(learningRateStr);
		Double maxError = new Double(maxErrorStr);
		Integer maxIterations = 0;
		Double momentum = new Double(momentumStr);

		if (limitIterationsCheckBox.isSelected()) {
                   maxIterations = new Integer(maxIterationsStr);
                }

		trainingController.setLmsParams(learningRate, maxError, maxIterations);

		LMS learningRule = (LMS) this.trainingController.getNeuralNetAndDataSet().getNetwork().getLearningRule();

		if (learningRule instanceof MomentumBackpropagation) {
			((MomentumBackpropagation)learningRule).setMomentum(momentum);
		}

                if (crossValidationCheckBox.isSelected()) {
                    trainingController.setUseCrossvalidation(true);
                    trainingController.setSaveNetworks(saveNetworksCheckBox.isSelected());
                    trainingController.setNumberOfCrossvalSubsets(Integer.parseInt( subsetCountField.getText().trim()));
                }

                if (graphCheckBox.isSelected()) {
                    GraphFrameTopComponent graphFrame = openErrorGraphFrame();
                    graphFrame.setTrainingController(trainingController);
                    graphFrame.observe(learningRule);
                }

                trainingController.train();

                this.dispose();
    }//GEN-LAST:event_trainButtonActionPerformed

    private GraphFrameTopComponent openErrorGraphFrame() {
        GraphFrameTopComponent graphFrame = new GraphFrameTopComponent();
        graphFrame.open();
        graphFrame.requestActive();
        return graphFrame;
    }    
    
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
       this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void limitIterationsCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_limitIterationsCheckBoxStateChanged
        if (this.maxIterationsField.isEnabled()) {
            this.maxIterationsField.setEnabled(false);
        } else {
            this.maxIterationsField.setEnabled(true);
        }
    }//GEN-LAST:event_limitIterationsCheckBoxStateChanged

    private void crossValidationCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_crossValidationCheckBoxItemStateChanged
        if (crossValidationCheckBox.isSelected()) {
            graphCheckBox.setSelected(false);
            graphCheckBox.setEnabled(false);
            saveNetworksCheckBox.setEnabled(true);
        } else {
            graphCheckBox.setEnabled(true);
            graphCheckBox.setSelected(true);
            subsetCountField.setEnabled(false);
            saveNetworksCheckBox.setEnabled(false);
        }
    }//GEN-LAST:event_crossValidationCheckBoxItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewSupervisedTrainingDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewSupervisedTrainingDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewSupervisedTrainingDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewSupervisedTrainingDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewSupervisedTrainingDialog dialog = new NewSupervisedTrainingDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton closeButton;
    private javax.swing.JCheckBox crossValidationCheckBox;
    private javax.swing.JCheckBox deepNettsCheckBox;
    private javax.swing.JCheckBox graphCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField learningRateField;
    private javax.swing.JCheckBox limitIterationsCheckBox;
    private javax.swing.JTextField maxErrorField;
    private javax.swing.JTextField maxIterationsField;
    private javax.swing.JTextField momentumField;
    private javax.swing.JLabel momentumLabel;
    private javax.swing.JCheckBox saveNetworksCheckBox;
    private javax.swing.JTextField subsetCountField;
    private javax.swing.JButton trainButton;
    // End of variables declaration//GEN-END:variables
}