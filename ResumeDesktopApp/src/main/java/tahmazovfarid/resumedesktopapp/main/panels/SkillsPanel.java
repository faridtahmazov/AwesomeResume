/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tahmazovfarid.resumedesktopapp.main.panels;

import config.Config;
import daoInter.SkillDaoInter;
import daoInter.UserSkillDaoInter;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import static javax.management.Query.value;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Skill;
import model.User;
import model.UserSkill;

///**
// *
// * @author TahmazovFarid
// */
public class SkillsPanel extends javax.swing.JPanel {

    SkillDaoInter skillDaoInter = Config.skillDaoInter;
    UserSkillDaoInter userSkillDaoInter = Config.userSkillDaoInter;
    User loggedInUser = Config.loggedInUser;
    boolean lock = false;
    //UserSkill loggedInUserSkill = (UserSkill) Config.loggedInUserSkill;
    
    
    public SkillsPanel() {
        initComponents();
        
    }
    
    public void fillUserComponents(){
        fillWindow();
    }
    
    List<UserSkill> userSkills;
    private void fillTable(){
        userSkills = userSkillDaoInter.getAllSkillByUserId(loggedInUser.getId());
        Vector<Vector> rows = new Vector<>();
       
        for (UserSkill us: userSkills){
            Vector row = new Vector();
            row.add(us.getSkill());
            row.add(us.getPower());
            rows.add(row);
        }
        DefaultTableModel model = new DefaultTableModel(rows, new Vector(Arrays.asList("Skill", "Power"))){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
            }
        };
        skillTb.setModel(model);
    }
    
    
    private void fillWindow(){
       List<Skill> skills = skillDaoInter.getAllSkill();
            if (lock==false){
                for (Skill s: skills){
                    skillCb.addItem(s);
                }
                lock=true;
            }
        fillTable();
    }
   
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        skillCb = new javax.swing.JComboBox<>();
        powerSldr = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        addSkillTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        skillTb = new javax.swing.JTable();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Skill");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        skillCb.setToolTipText("Choose language");
        skillCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skillCbActionPerformed(evt);
            }
        });

        powerSldr.setMajorTickSpacing(1);
        powerSldr.setMaximum(10);
        powerSldr.setMinorTickSpacing(2);
        powerSldr.setPaintLabels(true);
        powerSldr.setPaintTicks(true);
        powerSldr.setValue(1);

        jLabel2.setText("Power");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        addBtn.setText("+");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        delBtn.setText("-");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Don't find?");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        skillTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Skill", "Power"
            }
        ));
        skillTb.setShowGrid(true);
        jScrollPane1.setViewportView(skillTb);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addSkillTxt)
                            .addComponent(skillCb, 0, 90, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(powerSldr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addBtn, delBtn});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(powerSldr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(skillCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addSkillTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(delBtn))
                .addGap(300, 300, 300))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 133, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, skillCb});

    }// </editor-fold>//GEN-END:initComponents
//
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        Skill skill = null;
        String newSkill = addSkillTxt.getText();
        int power = powerSldr.getValue();

        if (newSkill.isEmpty() || newSkill.equals(null)){
           skill = (Skill) skillCb.getSelectedItem();
        }else{
            skill = new Skill(0, newSkill);
            skillDaoInter.insertSkill(skill);
        }
        UserSkill us = new UserSkill(null, loggedInUser, skill, power);
        userSkillDaoInter.addUserSkill(us);
        fillWindow();
    }//GEN-LAST:event_addBtnActionPerformed

    private void skillCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skillCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skillCbActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        int index = skillTb.getSelectedRow();
        System.out.println("Index: " + index);
        UserSkill userSkill = userSkills.get(index);
  
        System.out.println("\nUserSkill: " + userSkill.getId());
        userSkillDaoInter.deleteUserSkill(userSkill.getId());
        fillWindow();
    }//GEN-LAST:event_delBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField addSkillTxt;
    private javax.swing.JButton delBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider powerSldr;
    private javax.swing.JComboBox<Skill> skillCb;
    private javax.swing.JTable skillTb;
    // End of variables declaration//GEN-END:variables
}
