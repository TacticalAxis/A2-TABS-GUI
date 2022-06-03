package a2.tabs.gui.view.admin;

import a2.tabs.gui.Tabs;
import a2.tabs.gui.database.DBConnection;
import a2.tabs.gui.view.admin.panel.AdminCharge;
import a2.tabs.gui.view.admin.panel.AdminHome;
import a2.tabs.gui.view.admin.panel.AdminMessages;
import a2.tabs.gui.view.admin.panel.AdminUsers;
import a2.tabs.gui.view.main.TabStartup;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;

@SuppressWarnings("FieldCanBeLocal")
public class AdminDashboard extends JFrame {

    public JPanel currentPanel;

    private JButton sbChargeUsersButton;
    private JButton sbExitButton;
    private JButton sbHomeButton;
    private JButton sbMessagesButton;
    private JButton sbSettingsButton;
    private JButton sbTitleButton;
    private JButton sbUsersButton;
    private JPanel sideBar;

    public AdminDashboard() {
        initComponents();
        this.setResizable(false);
        try {UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ignored) {}
    }

    private void initComponents() {
        sideBar = new JPanel();
        sbTitleButton = new JButton();
        sbHomeButton = new JButton();
        sbSettingsButton = new JButton();
        sbExitButton = new JButton();
        sbUsersButton = new JButton();
        sbMessagesButton = new JButton();
        sbChargeUsersButton = new JButton();

        currentPanel = new AdminHome(this);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("The Awesomest Billing System");
        setBackground(new Color(51, 51, 51));

        sideBar.setBackground(new Color(51, 51, 51));

        sbTitleButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\tabs-logo-dash2.png")); // NOI18N
        sbTitleButton.setBorderPainted(false);
        sbTitleButton.setContentAreaFilled(false);

        sbHomeButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\Menu-Home.png")); // NOI18N
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

        sbSettingsButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\Blank.png")); // NOI18N
        sbSettingsButton.setBorder(null);
        sbSettingsButton.setBorderPainted(false);
        sbSettingsButton.setContentAreaFilled(false);
        sbSettingsButton.setMaximumSize(new Dimension(75, 75));
        sbSettingsButton.setMinimumSize(new Dimension(75, 75));
        sbSettingsButton.setEnabled(false);

        sbExitButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\Menu-Exit.png")); // NOI18N
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

        sbUsersButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\AdminOptionPane-Users.png")); // NOI18N
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

        sbMessagesButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\OptionPane-Messages.png")); // NOI18N
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

        sbChargeUsersButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\AdminOptionPane-Charge.png")); // NOI18N
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
        if (Tabs.tabStartup != null) {
            Tabs.tabStartup.dispose();
        }
        Tabs.tabStartup = new TabStartup();
        Tabs.tabStartup.setVisible(true);
    }

    public static void main(String[] args) {
        Tabs.db = new DBConnection();
        System.out.println("Welcome Admin");
        EventQueue.invokeLater(() -> new AdminDashboard().setVisible(true));
    }
}