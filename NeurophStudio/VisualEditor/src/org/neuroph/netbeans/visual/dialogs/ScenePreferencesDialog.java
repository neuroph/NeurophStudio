/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neuroph.netbeans.visual.dialogs;

import java.awt.Frame;
import org.neuroph.netbeans.visual.widgets.NeuralNetworkScene;

/**
 *
 * @author Maja
 */
public class ScenePreferencesDialog extends javax.swing.JDialog {

    NeuralNetworkScene scene;
    /**
     * Creates new form ScenePreferencesDialog
     */
    public ScenePreferencesDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public ScenePreferencesDialog(NeuralNetworkScene scene, Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.scene = scene;
        checkBoxShowConnections.setSelected(scene.getScenePreferences().isShowConnections());
        checkBoxShowActivationSize.setSelected(scene.getScenePreferences().isShowActivationSize());
        checkBoxShowActivationColor.setSelected(scene.getScenePreferences().isShowActivationColor());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkBoxShowConnections = new javax.swing.JCheckBox();
        checkBoxShowActivationSize = new javax.swing.JCheckBox();
        checkBoxShowActivationColor = new javax.swing.JCheckBox();
        buttonOK = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(ScenePreferencesDialog.class, "ScenePreferencesDialog.title")); // NOI18N
        setIconImages(null);

        org.openide.awt.Mnemonics.setLocalizedText(checkBoxShowConnections, org.openide.util.NbBundle.getMessage(ScenePreferencesDialog.class, "ScenePreferencesDialog.checkBoxShowConnections.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(checkBoxShowActivationSize, org.openide.util.NbBundle.getMessage(ScenePreferencesDialog.class, "ScenePreferencesDialog.checkBoxShowActivationSize.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(checkBoxShowActivationColor, org.openide.util.NbBundle.getMessage(ScenePreferencesDialog.class, "ScenePreferencesDialog.checkBoxShowActivationColor.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonOK, org.openide.util.NbBundle.getMessage(ScenePreferencesDialog.class, "ScenePreferencesDialog.buttonOK.text")); // NOI18N
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(buttonCancel, org.openide.util.NbBundle.getMessage(ScenePreferencesDialog.class, "ScenePreferencesDialog.buttonCancel.text")); // NOI18N
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxShowActivationSize)
                    .addComponent(checkBoxShowConnections)
                    .addComponent(checkBoxShowActivationColor)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonOK)
                        .addGap(29, 29, 29)
                        .addComponent(buttonCancel)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(checkBoxShowConnections)
                .addGap(18, 18, 18)
                .addComponent(checkBoxShowActivationSize)
                .addGap(18, 18, 18)
                .addComponent(checkBoxShowActivationColor)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        this.dispose();
        scene.showActivationSize(checkBoxShowActivationSize.isSelected());
        scene.showActiovationColor(checkBoxShowActivationColor.isSelected());
        scene.showConnections(checkBoxShowConnections.isSelected());
    }//GEN-LAST:event_buttonOKActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

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
            java.util.logging.Logger.getLogger(ScenePreferencesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScenePreferencesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScenePreferencesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScenePreferencesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ScenePreferencesDialog dialog = new ScenePreferencesDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonOK;
    private javax.swing.JCheckBox checkBoxShowActivationColor;
    private javax.swing.JCheckBox checkBoxShowActivationSize;
    private javax.swing.JCheckBox checkBoxShowConnections;
    // End of variables declaration//GEN-END:variables
}
