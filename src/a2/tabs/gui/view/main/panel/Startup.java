package a2.tabs.gui.view.main.panel;

import a2.tabs.gui.Tabs;
import a2.tabs.gui.view.admin.AdminDashboard;
import a2.tabs.gui.view.main.TabsStartup;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Startup extends JPanel {
    private final TabsStartup tabsStartup;

    public Startup(TabsStartup tabsStartup) {
        this.tabsStartup = tabsStartup;
        initComponents();
    }

    private void initComponents() {
        JLabel pgMainTitleLogo = new JLabel();
        JTextField pgMainFiller = new JTextField();
        JButton pgMainLoginButton = new JButton();
        JButton pgMainRegisterButton = new JButton();
        JButton pgMainExitButton = new JButton();
        JLabel adminIcon = new JLabel();
        JLabel adminLabel = new JLabel();

        setForeground(new Color(246, 247, 251));

        pgMainTitleLogo.setIcon(new ImageIcon("resources/image/StartupPage-Logo.png"));

        pgMainFiller.setEditable(false);
        pgMainFiller.setBackground(new Color(204, 204, 204));
        pgMainFiller.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgMainFiller.setForeground(new Color(102, 102, 102));
        pgMainFiller.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgMainFiller.setCaretColor(new Color(102, 102, 102));
        pgMainFiller.setOpaque(true);
        pgMainFiller.setSelectionColor(new Color(252, 189, 27));

        pgMainLoginButton.setBackground(new Color(0, 100, 172));
        pgMainLoginButton.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        pgMainLoginButton.setForeground(new Color(204, 204, 204));
        pgMainLoginButton.setIcon(new ImageIcon("resources/image/StartupPage-Login.png"));
        pgMainLoginButton.setBorder(null);
        pgMainLoginButton.setBorderPainted(false);
        pgMainLoginButton.setContentAreaFilled(false);
        pgMainLoginButton.addActionListener(evt -> {
            tabsStartup.remove(tabsStartup.currentPanel);
            tabsStartup.currentPanel = new Login(tabsStartup);
            tabsStartup.setDisplay(tabsStartup.currentPanel);
        });

        pgMainRegisterButton.setBackground(new Color(0, 100, 172));
        pgMainRegisterButton.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        pgMainRegisterButton.setForeground(new Color(204, 204, 204));
        pgMainRegisterButton.setIcon(new ImageIcon("resources/image/StartupPage-Register.png"));
        pgMainRegisterButton.setBorder(null);
        pgMainRegisterButton.setBorderPainted(false);
        pgMainRegisterButton.setContentAreaFilled(false);
        pgMainRegisterButton.addActionListener(evt -> {
            tabsStartup.remove(tabsStartup.currentPanel);
            tabsStartup.currentPanel = new Register(tabsStartup);
            tabsStartup.setDisplay(tabsStartup.currentPanel);
        });

        pgMainExitButton.setBackground(new Color(0, 100, 172));
        pgMainExitButton.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        pgMainExitButton.setForeground(new Color(204, 204, 204));
        pgMainExitButton.setIcon(new ImageIcon("resources/image/StartupPage-Exit.png"));
        pgMainExitButton.setBorder(null);
        pgMainExitButton.setBorderPainted(false);
        pgMainExitButton.setContentAreaFilled(false);
        pgMainExitButton.addActionListener(evt -> System.exit(0));

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String testAdmin = JOptionPane.showInputDialog("Please enter the admin password: ");
                if (testAdmin != null) {
                    if (testAdmin.equals("supersecretadminpassword")) {
                        Tabs.tabsStartup.dispose();
                        Tabs.adminDashboard = new AdminDashboard();
                        EventQueue.invokeLater(() -> Tabs.adminDashboard.setVisible(true));
                    }
                }
            }
        };

        adminIcon.setIcon(new ImageIcon("resources/image/Startup-Admin.png"));
        adminIcon.setText("jLabel1");

        adminIcon.addMouseListener(mouseAdapter);

        adminLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
        adminLabel.setText("Admin:");

        adminLabel.addMouseListener(mouseAdapter);

        GroupLayout pgMainPanelLayout = new GroupLayout(this);
        setLayout(pgMainPanelLayout);
        pgMainPanelLayout.setHorizontalGroup(
                pgMainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgMainPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(pgMainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(pgMainPanelLayout.createSequentialGroup()
                                                .addComponent(adminLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(adminIcon, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pgMainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(GroupLayout.Alignment.LEADING, pgMainPanelLayout.createSequentialGroup()
                                                        .addGroup(pgMainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(pgMainRegisterButton, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(pgMainExitButton, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(pgMainLoginButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(pgMainFiller))
                                                .addComponent(pgMainTitleLogo)))
                                .addContainerGap(22, Short.MAX_VALUE))
        );
        pgMainPanelLayout.setVerticalGroup(
                pgMainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgMainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pgMainTitleLogo, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addGroup(pgMainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pgMainPanelLayout.createSequentialGroup()
                                                .addComponent(pgMainLoginButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(pgMainRegisterButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(pgMainExitButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(pgMainFiller))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pgMainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(adminIcon, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(adminLabel))
                                .addContainerGap(11, Short.MAX_VALUE))
        );
    }
}
