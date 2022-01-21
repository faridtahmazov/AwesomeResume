 package tahmazovfarid.resumedesktopapp.main;

import config.Config;
import tahmazovfarid.resumedesktopapp.main.panels.DetailsPanel;
import tahmazovfarid.resumedesktopapp.main.panels.ProfilePanel;
import model.Context;
import daoInter.UserDaoInter;
import daoInter.CountryDaoInter;
import javax.swing.JOptionPane;
import model.User;


public class Main extends javax.swing.JFrame {

    private UserDaoInter udi = Context.getInstanceUserDao(); 
    private CountryDaoInter cdi = Context.getInstanceCountryDao();
    private User loggedIn = Config.loggedInUser;
    private ProfilePanel profilePanel = new ProfilePanel();
    private DetailsPanel detailsPanel = new DetailsPanel();
    
    public Main() {
        initComponents();
        fillUserMain();
        profilePanel.fillUserComponents();
        detailsPanel.fillUserComponents();
        skillsPanelForm.fillUserComponents();
        
    }
    
    private void fillUserMain(){
        nameTxt.setText(loggedIn.getName());
        surnameTxt.setText(loggedIn.getSurname());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        nameLb = new javax.swing.JLabel();
        surnameLb = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        surnameTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        tabPanel = new javax.swing.JTabbedPane();
        detailsPanelForm = new tahmazovfarid.resumedesktopapp.main.panels.DetailsPanel();
        profilePanelForm = new tahmazovfarid.resumedesktopapp.main.panels.ProfilePanel();
        skillsPanelForm = new tahmazovfarid.resumedesktopapp.main.panels.SkillsPanel();
        empHistoryPanelForm = new tahmazovfarid.resumedesktopapp.main.panels.EmpHistoryPanel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameLb.setText("Name");
        nameLb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        surnameLb.setText("Surname");
        surnameLb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        surnameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameTxtActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(surnameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(nameTxt))
                .addGap(117, 117, 117))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLb)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameLb)
                    .addComponent(surnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabPanel.addTab("Details", detailsPanelForm);
        tabPanel.addTab("Profile", profilePanelForm);
        tabPanel.addTab("Skills", skillsPanelForm);
        tabPanel.addTab("Employed HIstory", empHistoryPanelForm);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void surnameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameTxtActionPerformed

    }//GEN-LAST:event_surnameTxtActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        String name = nameTxt.getText();
        String surname = surnameTxt.getText();
        
        loggedIn.setName(name);
        loggedIn.setSurname(surname);
        profilePanelForm.getFilledUserProfile(loggedIn);
        detailsPanelForm.getFilledUserDetails(loggedIn);
        empHistoryPanelForm.getFilledUserEmp(loggedIn);
        
        udi.update(loggedIn);
        
        JOptionPane.showMessageDialog(null, "Updated successful!");
    }//GEN-LAST:event_saveBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tahmazovfarid.resumedesktopapp.main.panels.DetailsPanel detailsPanelForm;
    private tahmazovfarid.resumedesktopapp.main.panels.EmpHistoryPanel empHistoryPanelForm;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel nameLb;
    private javax.swing.JTextField nameTxt;
    private tahmazovfarid.resumedesktopapp.main.panels.ProfilePanel profilePanelForm;
    private javax.swing.JButton saveBtn;
    private tahmazovfarid.resumedesktopapp.main.panels.SkillsPanel skillsPanelForm;
    private javax.swing.JLabel surnameLb;
    private javax.swing.JTextField surnameTxt;
    private javax.swing.JTabbedPane tabPanel;
    // End of variables declaration//GEN-END:variables
}
