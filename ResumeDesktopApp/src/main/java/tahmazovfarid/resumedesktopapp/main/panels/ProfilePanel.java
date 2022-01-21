package tahmazovfarid.resumedesktopapp.main.panels;

import model.User;
import config.Config;

public class ProfilePanel extends javax.swing.JPanel {

    private User user = Config.loggedInUser;
    public ProfilePanel() {
        initComponents();
        fillUserComponents();
    }
    
    public void fillUserComponents(){
        profDescText.setText(user.getProfileDescription());
    }
    
    public void getFilledUserProfile(User loggedIn){
         String profDesc = profDescText.getText();
         loggedIn.setProfileDescription(profDesc);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profPanel = new javax.swing.JScrollPane();
        profDescText = new javax.swing.JTextArea();

        profDescText.setColumns(20);
        profDescText.setLineWrap(true);
        profDescText.setRows(5);
        profPanel.setViewportView(profDescText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(profPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea profDescText;
    private javax.swing.JScrollPane profPanel;
    // End of variables declaration//GEN-END:variables
}
