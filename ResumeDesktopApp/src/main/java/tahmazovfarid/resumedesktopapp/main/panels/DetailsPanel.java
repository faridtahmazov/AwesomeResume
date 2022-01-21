package tahmazovfarid.resumedesktopapp.main.panels;

import daoInter.CountryDaoInter;
import daoInter.UserDaoInter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import model.Context;
import model.Country;
import model.User;
import config.Config;
import daoInter.CountryDaoInter;

public class DetailsPanel extends javax.swing.JPanel {

    private UserDaoInter udi = Context.getInstanceUserDao(); 
    private CountryDaoInter cdi = Context.getInstanceCountryDao();
    private User user = Config.loggedInUser;
    public DetailsPanel() {
        initComponents();
        fillUserComponents();
    }
    
     private void fillwindow(){
        List<Country> countries = cdi.getAllCountry();
        List<Country> nationalities = cdi.getAllNationality();
        
        for (Country n: nationalities){
            nationalityCb.addItem(n);
        }
        
        for (Country c: countries){
            countryCb.addItem(c);
        }
        
    }

    public void fillUserComponents() {
        emailTxt.setText(user.getEmail());
        phoneTxt.setText(user.getPhone());

        addressTxt.setText(user.getAddress());
        birthdateTxt.setText(user.getBirthdate().toString());
        
        fillwindow();
        
        countryCb.setSelectedItem(user.getCountry());
        nationalityCb.setSelectedIndex(user.getNationality().getId() - 1);
 
    }
    
    public void getFilledUserDetails(User u){
        String email = emailTxt.getText();
        String phone = phoneTxt.getText();       
        String address = addressTxt.getText();
        String birthdateStr = birthdateTxt.getText();
        Date birthdate = strConvertDate(birthdateStr);
        Country country = (Country) countryCb.getSelectedItem();
        Country nationality = (Country) nationalityCb.getSelectedItem();
        
        u.setEmail(email);
        u.setPhone(phone);
        u.setAddress(address);
        u.setBirthdate(birthdate);
        u.setCountry(country);
        u.setNationality(nationality);
      
    }
    
     private Date strConvertDate(String birthdateStr){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        java.util.Date date = null;
        try {
            date = (java.util.Date) sdf.parse(birthdateStr);
            
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        java.sql.Date birthdate = new java.sql.Date(date.getTime());
        
        return birthdate;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        detailsPanel = new javax.swing.JPanel();
        emailLb = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        phoneLb = new javax.swing.JLabel();
        phoneTxt = new javax.swing.JTextField();
        addressLb = new javax.swing.JLabel();
        addressTxt = new javax.swing.JTextField();
        birthdateLb = new javax.swing.JLabel();
        birthdateTxt = new javax.swing.JTextField();
        countryLb = new javax.swing.JLabel();
        nationalityLb = new javax.swing.JLabel();
        countryCb = new javax.swing.JComboBox<>();
        nationalityCb = new javax.swing.JComboBox<>();

        emailLb.setText("Email");
        emailLb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        phoneLb.setText("Phone");
        phoneLb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        addressLb.setText("Address");
        addressLb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        birthdateLb.setText("Birthdate");
        birthdateLb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        countryLb.setText("Country");
        countryLb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nationalityLb.setText("Nationality");
        nationalityLb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        countryCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryCbActionPerformed(evt);
            }
        });

        nationalityCb.setToolTipText("");
        nationalityCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nationalityCbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout detailsPanelLayout = new javax.swing.GroupLayout(detailsPanel);
        detailsPanel.setLayout(detailsPanelLayout);
        detailsPanelLayout.setHorizontalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addComponent(countryLb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(countryCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addComponent(birthdateLb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(birthdateTxt))
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addComponent(addressLb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addressTxt))
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addComponent(phoneLb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneTxt))
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addComponent(emailLb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addComponent(nationalityLb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nationalityCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        detailsPanelLayout.setVerticalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLb)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLb)
                    .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLb)
                    .addComponent(addressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthdateLb)
                    .addComponent(birthdateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(countryLb)
                    .addComponent(countryCb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nationalityLb)
                    .addComponent(nationalityCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(detailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(detailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void countryCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryCbActionPerformed

    }//GEN-LAST:event_countryCbActionPerformed

    private void nationalityCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nationalityCbActionPerformed

    }//GEN-LAST:event_nationalityCbActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLb;
    private javax.swing.JTextField addressTxt;
    private javax.swing.JLabel birthdateLb;
    private javax.swing.JTextField birthdateTxt;
    private javax.swing.JComboBox<Country> countryCb;
    private javax.swing.JLabel countryLb;
    private javax.swing.JPanel detailsPanel;
    private javax.swing.JLabel emailLb;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JComboBox<Country> nationalityCb;
    private javax.swing.JLabel nationalityLb;
    private javax.swing.JLabel phoneLb;
    private javax.swing.JTextField phoneTxt;
    // End of variables declaration//GEN-END:variables
}
