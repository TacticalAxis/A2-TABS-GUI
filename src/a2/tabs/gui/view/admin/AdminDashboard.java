package a2.tabs.gui.view.admin;

import a2.tabs.gui.Tabs;
import a2.tabs.gui.view.admin.panel.AdminCharge;
import a2.tabs.gui.view.admin.panel.AdminHome;
import a2.tabs.gui.view.admin.panel.AdminMessages;
import a2.tabs.gui.view.admin.panel.AdminUsers;
import a2.tabs.gui.view.main.TabsStartup;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;

public class AdminDashboard extends JFrame {

    public JPanel currentPanel;

    private JPanel sideBar;

    public AdminDashboard() {
        initComponents();
        this.setResizable(false);
        try {UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ignored) {}
    }

    private void initComponents() {
        sideBar = new JPanel();
        JButton sbTitleButton = new JButton();
        JButton sbHomeButton = new JButton();
        JButton sbSettingsButton = new JButton();
        JButton sbExitButton = new JButton();
        JButton sbUsersButton = new JButton();
        JButton sbMessagesButton = new JButton();
        JButton sbChargeUsersButton = new JButton();

        currentPanel = new AdminHome(this);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("The Awesomest Billing System");
        setBackground(new Color(51, 51, 51));

        sideBar.setBackground(new Color(51, 51, 51));

        sbTitleButton.setIcon(new ImageIcon("resources/image/tabs-logo-dash2.png"));
        sbTitleButton.setBorderPainted(false);
        sbTitleButton.setContentAreaFilled(false);

        sbHomeButton.setIcon(new ImageIcon("resources/image/Menu-Home.png"));
        sbHomeButton.setBorder(null);
        sbHomeButton.setBorderPainted(false);
        sbHomeButton.setContentAreaFilled(false);
        sbHomeButton.setMaximumSize(new Dimension(75, 75));
        sbHomeButton.setMinimumSize(new Dimension(75, 75));
        sbHomeButton.addActionListener(evt -> {
            if (currentPanel != null && !(currentPanel instanceof AdminHome)) {
                remove(currentPanel);
                currentPanel = new AdminHome(this);
                setDisplay(currentPanel);
            }
        });

        sbSettingsButton.setIcon(new ImageIcon("resources/image/Blank.png"));
        sbSettingsButton.setBorder(null);
        sbSettingsButton.setBorderPainted(false);
        sbSettingsButton.setContentAreaFilled(false);
        sbSettingsButton.setMaximumSize(new Dimension(75, 75));
        sbSettingsButton.setMinimumSize(new Dimension(75, 75));
        sbSettingsButton.setEnabled(false);

        sbExitButton.setIcon(new ImageIcon("resources/image/Menu-Exit.png"));
        sbExitButton.setBorder(null);
        sbExitButton.setBorderPainted(false);
        sbExitButton.setContentAreaFilled(false);
        sbExitButton.setMaximumSize(new Dimension(75, 75));
        sbExitButton.setMinimumSize(new Dimension(75, 75));
        sbExitButton.addActionListener(evt -> {
            String[] options = {"Logout", "Exit"};
            int result = JOptionPane.showOptionDialog(
                    this,
                    "Quit Tabs?",
                    "Exit",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (result == JOptionPane.YES_OPTION) {
                logout();
            } else if (result == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        });

        sbUsersButton.setIcon(new ImageIcon("resources/image/AdminOptionPane-Users.png"));
        sbUsersButton.setBorder(null);
        sbUsersButton.setBorderPainted(false);
        sbUsersButton.setContentAreaFilled(false);
        sbUsersButton.addActionListener(evt -> {
            if (currentPanel != null && !(currentPanel instanceof AdminUsers)) {
                remove(currentPanel);
                currentPanel = new AdminUsers(this);
                setDisplay(currentPanel);
            }
        });

        sbMessagesButton.setIcon(new ImageIcon("resources/image/OptionPane-Messages.png"));
        sbMessagesButton.setBorder(null);
        sbMessagesButton.setBorderPainted(false);
        sbMessagesButton.setContentAreaFilled(false);
        sbMessagesButton.addActionListener(evt -> {
            if (currentPanel != null && !(currentPanel instanceof AdminMessages)) {
                remove(currentPanel);
                currentPanel = new AdminMessages(this);
                setDisplay(currentPanel);
            }
        });

        sbChargeUsersButton.setIcon(new ImageIcon("resources/image/AdminOptionPane-Charge.png"));
        sbChargeUsersButton.setBorder(null);
        sbChargeUsersButton.setBorderPainted(false);
        sbChargeUsersButton.setContentAreaFilled(false);
        sbChargeUsersButton.addActionListener(evt -> {
            if (currentPanel != null && !(currentPanel instanceof AdminCharge)) {
                remove(currentPanel);
                currentPanel = new AdminCharge(this);
                setDisplay(currentPanel);
            }
        });

        GroupLayout sideBarLayout = new GroupLayout(sideBar);
        sideBar.setLayout(sideBarLayout);
        sideBarLayout.setHorizontalGroup(
            sideBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, sideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sideBarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(sbUsersButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sbMessagesButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sbChargeUsersButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.LEADING, sideBarLayout.createSequentialGroup()
                        .addGroup(sideBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(sideBarLayout.createSequentialGroup()
                                .addComponent(sbHomeButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sbSettingsButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sbExitButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                            .addComponent(sbTitleButton, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        sideBarLayout.setVerticalGroup(
            sideBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sbTitleButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(sideBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(sbHomeButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sbSettingsButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sbExitButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(sbUsersButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sbMessagesButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sbChargeUsersButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267))
        );

        setDisplay(currentPanel);
        pack();
    }

    public void setDisplay(JPanel panel) {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(sideBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(sideBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    //
    public void refreshCurrentPanel() {
        currentPanel.removeAll();
        remove(currentPanel);
        try {
            Class<?> clazz = Class.forName(currentPanel.getClass().getName());
            Constructor<?> ctor = clazz.getConstructor(AdminDashboard.class);
            Object object = ctor.newInstance(this);

            currentPanel = (JPanel) object;
            setDisplay(currentPanel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void logout() {
        Tabs.adminDashboard.dispose();
        if (Tabs.tabsStartup != null) {
            Tabs.tabsStartup.dispose();
        }
        Tabs.tabsStartup = new TabsStartup();
        Tabs.tabsStartup.setVisible(true);
    }
}