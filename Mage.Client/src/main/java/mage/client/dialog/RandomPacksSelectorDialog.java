package mage.client.dialog;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import mage.cards.repository.ExpansionInfo;
import mage.cards.repository.ExpansionRepository;

/**
 *
 * @author BrodyL
 */
public class RandomPacksSelectorDialog extends javax.swing.JDialog {

    /**
     * Creates new form RandomPacksSelectorDialog
     */
    private boolean boxesCreated;
    public static final String randomDraftDescription = ("The selected packs will be randomly distributed to players. Each player may open different packs. Duplicates will be avoided.");

    public RandomPacksSelectorDialog() {
        initComponents();
        this.pnlApply.setToolTipText(randomDraftDescription);
        this.pnlSelect.setToolTipText(randomDraftDescription);
        boxesCreated = false;
    }

    private void setType(boolean isRandomDraft, boolean isRichManDraft, boolean isReshuffledDraft) {
        String title;
        if (isRandomDraft) {
            title = "Random Booster Draft Packs Selector";
        } else if (isRichManDraft) {
            title = "Rich Man Booster Draft Packs Selector";
        } else if (isReshuffledDraft) {
            title = "Chaos Reshuffled Draft Set Selector";
        } else {
            title = "Booster Draft Packs Selector";
        }
        setTitle(title);
    }

    public void showDialog(boolean isRandomDraft, boolean isRichManDraft, boolean isReshuffledDraft) {
        setType(isRandomDraft, isRichManDraft, isReshuffledDraft);
        createCheckboxes();
        pnlPacks.setVisible(true);
        pnlPacks.revalidate();
        pnlPacks.repaint();
        this.pack();
        this.revalidate();
        this.repaint();
        this.setVisible(true);
        this.setModal(true);
    }

    public void setSelectedPacks(List<String> packs) {
        if (!boxesCreated) {
            createCheckboxes();
        }
        for (Component pack : pnlPacks.getComponents()) {
            JCheckBox thePack = (JCheckBox) pack;
            if (packs.contains(thePack.getText())) {
                thePack.setSelected(true);
            } else {
                thePack.setSelected(false);
            }
        }
    }

    public List<String> getSelectedPacks() {
        List<String> returnVal = new ArrayList<>();
        for (Component pack : pnlPacks.getComponents()) {
            JCheckBox thePack = (JCheckBox) pack;
            if (thePack.isSelected()) {
                returnVal.add(thePack.getText());
            }
        }
        return returnVal;
    }

    private void createCheckboxes() {
        if (!boxesCreated) {
            ExpansionInfo[] allExpansions = ExpansionRepository.instance.getWithBoostersSortedByReleaseDate();
            for (ExpansionInfo exp : allExpansions) {
                JCheckBox pack = new JCheckBox();
                pack.setSelected(true);
                pack.setText(exp.getCode());
                pack.setToolTipText(exp.getName());
                pnlPacks.add(pack);
            }
            pnlPacks.setVisible(true);
            this.pack();
            boxesCreated = true;
            pnlPacks.validate();
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

        pnlPacks = new java.awt.Panel();
        pnlSelect = new javax.swing.JPanel();
        btnNone = new javax.swing.JButton();
        btnAll = new javax.swing.JButton();
        pnlApply = new javax.swing.JPanel();
        btnApply = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Random Booster Draft Packs Selector");
        setModal(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setPreferredSize(new java.awt.Dimension(875, 475));
        setResizable(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlPacks.setLayout(new java.awt.GridLayout(14, 14));

        pnlSelect.setLayout(new javax.swing.BoxLayout(pnlSelect, javax.swing.BoxLayout.LINE_AXIS));

        btnNone.setText("Select none");
        btnNone.setActionCommand("none");
        btnNone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoneActionPerformed(evt);
            }
        });
        pnlSelect.add(btnNone);

        btnAll.setText("Select all");
        btnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllActionPerformed(evt);
            }
        });
        pnlSelect.add(btnAll);

        pnlApply.setLayout(new javax.swing.BoxLayout(pnlApply, javax.swing.BoxLayout.LINE_AXIS));

        btnApply.setText("Apply");
        btnApply.setToolTipText("At least two packs must be selected");
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 402, Short.MAX_VALUE)
                        .addComponent(pnlApply, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnApply))
                    .addComponent(pnlPacks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPacks, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlApply, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApply))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActionPerformed
        setAllCheckBoxes(true);
    }//GEN-LAST:event_btnAllActionPerformed

    private void btnNoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoneActionPerformed
        setAllCheckBoxes(false);
    }//GEN-LAST:event_btnNoneActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        this.doApply();
    }//GEN-LAST:event_btnApplyActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.doApply();
    }//GEN-LAST:event_formWindowClosing

    public void doApply() {
        if (getSelectedPacks().size() < 1) {
            JOptionPane.showMessageDialog(this, "At least one set must be selected", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            this.setVisible(false);
        }
    }

    private void setAllCheckBoxes(boolean value) {
        for (Component pack : pnlPacks.getComponents()) {
            JCheckBox thePack = (JCheckBox) pack;
            thePack.setSelected(value);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnNone;
    private javax.swing.JPanel pnlApply;
    private java.awt.Panel pnlPacks;
    private javax.swing.JPanel pnlSelect;
    // End of variables declaration//GEN-END:variables
}
