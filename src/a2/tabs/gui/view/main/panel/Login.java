package a2.tabs.gui.view.main.panel;

import a2.tabs.gui.Tabs;
import a2.tabs.gui.model.User;
import a2.tabs.gui.view.main.TabStartup;
import a2.tabs.gui.view.user.Dashboard;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("FieldCanBeLocal")
public class Login extends JPanel {

    private final TabStartup tabStartup;

    private JButton pgLoginLoginButton;
    private JLabel pgLoginLogoLabel;
    private JPasswordField pgLoginPasswordInput;
    private JLabel pgLoginPasswordLabel;
    private JTextField pgLoginUsernameInput;
    private JLabel pgLoginUsernameLabel;

    public Login(TabStartup tabStartup) {
        this.tabStartup = tabStartup;
        initComponents();
    }

    private void initComponents() {
        pgLoginUsernameLabel = new JLabel();
        pgLoginUsernameInput = new JTextField();
        pgLoginPasswordLabel = new JLabel();
        pgLoginPasswordInput = new JPasswordField();
        pgLoginLoginButton = new JButton();
        pgLoginLogoLabel = new JLabel();

        setForeground(new Color(246, 247, 251));

        pgLoginUsernameLabel.setFont(new Font("Bahnschrift", 1, 24)); // NOI18N
        pgLoginUsernameLabel.setForeground(new Color(153, 153, 153));
        pgLoginUsernameLabel.setText("Username or Email");

        pgLoginUsernameInput.setBackground(new Color(204, 204, 204));
        pgLoginUsernameInput.setFont(new Font("Bahnschrift", 0, 18)); // NOI18N
        pgLoginUsernameInput.setForeground(new Color(102, 102, 102));
        pgLoginUsernameInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgLoginUsernameInput.setCaretColor(new Color(102, 102, 102));
        pgLoginUsernameInput.setOpaque(true);
        pgLoginUsernameInput.setSelectionColor(new Color(252, 189, 27));

        pgLoginPasswordLabel.setFont(new Font("Bahnschrift", 1, 24)); // NOI18N
        pgLoginPasswordLabel.setForeground(new Color(153, 153, 153));
        pgLoginPasswordLabel.setText("Password");

        pgLoginPasswordInput.setBackground(new Color(204, 204, 204));
        pgLoginPasswordInput.setFont(new Font("Bahnschrift", 0, 18)); // NOI18N
        pgLoginPasswordInput.setForeground(new Color(102, 102, 102));
        pgLoginPasswordInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgLoginPasswordInput.setCaretColor(new Color(102, 102, 102));
        pgLoginPasswordInput.setOpaque(true);
        pgLoginPasswordInput.setSelectionColor(new Color(252, 189, 27));

        pgLoginLoginButton.setBackground(new Color(0, 100, 172));
        pgLoginLoginButton.setFont(new Font("Bahnschrift", 1, 18)); // NOI18N
        pgLoginLoginButton.setForeground(new Color(204, 204, 204));
        pgLoginLoginButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\LoginPage-Submit.png")); // NOI18N
        pgLoginLoginButton.setBorder(null);
        pgLoginLoginButton.setBorderPainted(false);
        pgLoginLoginButton.setContentAreaFilled(false);
        pgLoginLoginButton.addActionListener(evt -> {
            String username = pgLoginUsernameInput.getText();
            String password = new String(pgLoginPasswordInput.getPassword());
            System.out.println("Username: " + username + " Password: " + password);

            User user = User.get(Tabs.db, username);
            if (user != null && user.checkPassword(new String(pgLoginPasswordInput.getPassword()))) {
                System.out.println("Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Login Failed", "Login Failed", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Tabs.tabStartup.dispose();
            Tabs.dashboard = new Dashboard(user);
            EventQueue.invokeLater(() -> Tabs.dashboard.setVisible(true));
        });

        pgLoginLogoLabel.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\RegisterPage-Logo.png")); // NOI18N
        pgLoginLogoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                tabStartup.remove(tabStartup.currentPanel);
                tabStartup.currentPanel = new Startup(tabStartup);
                tabStartup.setDisplay(tabStartup.currentPanel);
            }
        });

        GroupLayout pgLoginPanelLayout = new GroupLayout(this);
        setLayout(pgLoginPanelLayout);
        pgLoginPanelLayout.setHorizontalGroup(
                pgLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgLoginPanelLayout.createSequentialGroup()
                                .addGroup(pgLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(pgLoginPanelLayout.createSequentialGroup()
                                                .addGap(152, 152, 152)
                                                .addGroup(pgLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(pgLoginLoginButton)
                                                        .addGroup(GroupLayout.Alignment.LEADING, pgLoginPanelLayout.createSequentialGroup()
                                                                .addGroup(pgLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(pgLoginUsernameInput)
                                                                        .addComponent(pgLoginUsernameLabel, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(pgLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(pgLoginPasswordInput)
                                                                        .addGroup(pgLoginPanelLayout.createSequentialGroup()
                                                                                .addComponent(pgLoginPasswordLabel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))))))
                                        .addGroup(pgLoginPanelLayout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(pgLoginLogoLabel, GroupLayout.PREFERRED_SIZE, 1208, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(22, Short.MAX_VALUE))
        );
        pgLoginPanelLayout.setVerticalGroup(
                pgLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgLoginPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pgLoginLogoLabel, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                .addGap(163, 163, 163)
                                .addGroup(pgLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(pgLoginUsernameLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pgLoginPasswordLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pgLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(pgLoginUsernameInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pgLoginPasswordInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addComponent(pgLoginLoginButton)
                                .addContainerGap(169, Short.MAX_VALUE))
        );

    }
}
