/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package a2.old;

/**
 *
 * @author Nathan
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form Dash
     */
    public LoginPage() {
        initComponents();
        this.setResizable(false);
//        try {UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ignored) {}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pgLoginPanel = new javax.swing.JPanel();
        pgLoginUsernameLabel = new javax.swing.JLabel();
        pgLoginUsernameInput = new javax.swing.JTextField();
        pgLoginPasswordLabel = new javax.swing.JLabel();
        pgLoginPasswordInput = new javax.swing.JTextField();
        pgLoginLoginButton = new javax.swing.JButton();
        pgLoginLogoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("The Awesomest Billing System");
        setBackground(new java.awt.Color(51, 51, 51));

        pgLoginPanel.setForeground(new java.awt.Color(246, 247, 251));

        pgLoginUsernameLabel.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        pgLoginUsernameLabel.setForeground(new java.awt.Color(153, 153, 153));
        pgLoginUsernameLabel.setText("Username or Email");

        pgLoginUsernameInput.setBackground(new java.awt.Color(204, 204, 204));
        pgLoginUsernameInput.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        pgLoginUsernameInput.setForeground(new java.awt.Color(102, 102, 102));
        pgLoginUsernameInput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 5, true));
        pgLoginUsernameInput.setCaretColor(new java.awt.Color(102, 102, 102));
        pgLoginUsernameInput.setOpaque(true);
        pgLoginUsernameInput.setSelectionColor(new java.awt.Color(252, 189, 27));

        pgLoginPasswordLabel.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        pgLoginPasswordLabel.setForeground(new java.awt.Color(153, 153, 153));
        pgLoginPasswordLabel.setText("Password");

        pgLoginPasswordInput.setBackground(new java.awt.Color(204, 204, 204));
        pgLoginPasswordInput.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        pgLoginPasswordInput.setForeground(new java.awt.Color(102, 102, 102));
        pgLoginPasswordInput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 5, true));
        pgLoginPasswordInput.setCaretColor(new java.awt.Color(102, 102, 102));
        pgLoginPasswordInput.setOpaque(true);
        pgLoginPasswordInput.setSelectionColor(new java.awt.Color(252, 189, 27));

        pgLoginLoginButton.setBackground(new java.awt.Color(0, 100, 172));
        pgLoginLoginButton.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        pgLoginLoginButton.setForeground(new java.awt.Color(204, 204, 204));
        pgLoginLoginButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\LoginPage-Submit.png")); // NOI18N
        pgLoginLoginButton.setBorder(null);
        pgLoginLoginButton.setBorderPainted(false);
        pgLoginLoginButton.setContentAreaFilled(false);
        pgLoginLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pgLoginLoginButtonActionPerformed(evt);
            }
        });

        pgLoginLogoLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\RegisterPage-Logo.png")); // NOI18N

        javax.swing.GroupLayout pgLoginPanelLayout = new javax.swing.GroupLayout(pgLoginPanel);
        pgLoginPanel.setLayout(pgLoginPanelLayout);
        pgLoginPanelLayout.setHorizontalGroup(
            pgLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pgLoginPanelLayout.createSequentialGroup()
                .addGroup(pgLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pgLoginPanelLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(pgLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pgLoginLoginButton)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pgLoginPanelLayout.createSequentialGroup()
                                .addGroup(pgLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pgLoginUsernameInput)
                                    .addComponent(pgLoginUsernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pgLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pgLoginPasswordInput)
                                    .addGroup(pgLoginPanelLayout.createSequentialGroup()
                                        .addComponent(pgLoginPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(pgLoginPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(pgLoginLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pgLoginPanelLayout.setVerticalGroup(
            pgLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pgLoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pgLoginLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163)
                .addGroup(pgLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pgLoginUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pgLoginPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pgLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pgLoginUsernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pgLoginPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(pgLoginLoginButton)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pgLoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pgLoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pgLoginLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pgLoginLoginButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pgLoginLoginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton pgLoginLoginButton;
    private javax.swing.JLabel pgLoginLogoLabel;
    private javax.swing.JPanel pgLoginPanel;
    private javax.swing.JTextField pgLoginPasswordInput;
    private javax.swing.JLabel pgLoginPasswordLabel;
    private javax.swing.JTextField pgLoginUsernameInput;
    private javax.swing.JLabel pgLoginUsernameLabel;
    // End of variables declaration//GEN-END:variables
}
