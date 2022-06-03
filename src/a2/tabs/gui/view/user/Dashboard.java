package a2.tabs.gui.view.user;

import a2.tabs.gui.Tabs;
import a2.tabs.gui.database.DBConnection;
import a2.tabs.gui.model.User;
import a2.tabs.gui.view.main.TabStartup;
import a2.tabs.gui.view.user.panel.*;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;

@SuppressWarnings({"DuplicatedCode", "FieldCanBeLocal"})
public class Dashboard extends JFrame {

    private final User user;
    public JPanel currentPanel;

    private JButton sbExitButton;
    private JButton sbHomeButton;
    private JButton sbMessagesButton;
    private JButton sbPaymentsButton;
    private JButton sbProfileButton;
    private JButton sbSettingsButton;
    private JButton sbTaxCalculator;
    private JButton sbTitleButton;
    private JPanel sideBar;

    public Dashboard(User user) {
        this.user = user;
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
        sbProfileButton = new JButton();
        sbMessagesButton = new JButton();
        sbPaymentsButton = new JButton();
        sbTaxCalculator = new JButton();

        // setup panels
        currentPanel = new HomePanel(user, this);

        // setup frame configuration
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("The Awesomest Billing System");
        setBackground(new Color(51, 51, 51));

        sideBar.setBackground(new Color(51, 51, 51));
        sideBar.setForeground(new Color(51, 51, 51));

        sbTitleButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\tabs-logo-dash2.png"));
        sbTitleButton.setBorderPainted(false);
        sbTitleButton.setContentAreaFilled(false);

        sbHomeButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\Menu-Home.png"));
        sbHomeButton.setBorder(null);
        sbHomeButton.setBorderPainted(false);
        sbHomeButton.setContentAreaFilled(false);
        sbHomeButton.setMaximumSize(new Dimension(75, 75));
        sbHomeButton.setFocusPainted(false);
        sbHomeButton.addActionListener(evt -> {
            if (currentPanel != null && !(currentPanel instanceof HomePanel)) {
                remove(currentPanel);
                currentPanel = new HomePanel(user, this);
                setDisplay(currentPanel);
            }
        });

        sbSettingsButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\Menu-Settings.png"));
        sbSettingsButton.setBorder(null);
        sbSettingsButton.setBorderPainted(false);
        sbSettingsButton.setContentAreaFilled(false);
        sbSettingsButton.setFocusPainted(false);
        sbSettingsButton.setMaximumSize(new Dimension(75, 75));
        sbSettingsButton.setMinimumSize(new Dimension(75, 75));
        sbSettingsButton.addActionListener(evt -> {
            String[] options = {"Delete Account", "Cancel"};
            int result = JOptionPane.showOptionDialog(
                    null,
                    "What would you like to do?",
                    "Settings",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    // no icon
                    null,
                    // button text
                    options,
                    // default
                    options[0]
            );

            if (result == JOptionPane.YES_OPTION) {
                System.out.println("Delete Account");
                logout();
                user.delete(Tabs.db);
            } else {
                System.out.println("Cancelled");
            }
        });

        sbExitButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\Menu-Exit.png"));
        sbExitButton.setBorder(null);
        sbExitButton.setBorderPainted(false);
        sbExitButton.setContentAreaFilled(false);
        sbExitButton.setFocusPainted(false);
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

        sbProfileButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\OptionPane-Profile.png"));
        sbProfileButton.setBorder(null);
        sbProfileButton.setBorderPainted(false);
        sbProfileButton.setContentAreaFilled(false);
        sbProfileButton.addActionListener(evt -> {
            if (currentPanel != null && !(currentPanel instanceof ProfilePanel)) {
                remove(currentPanel);
                currentPanel = new ProfilePanel(user, this);
                setDisplay(currentPanel);
            }
        });

        sbMessagesButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\OptionPane-Messages.png"));
        sbMessagesButton.setBorder(null);
        sbMessagesButton.setBorderPainted(false);
        sbMessagesButton.setContentAreaFilled(false);
        sbMessagesButton.addActionListener(evt -> {
            if (currentPanel != null && !(currentPanel instanceof MessagePanel)) {
                remove(currentPanel);
                currentPanel = new MessagePanel(user, this);
                setDisplay(currentPanel);
            }
        });

        sbPaymentsButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\OptionPane-Payments.png"));
        sbPaymentsButton.setBorder(null);
        sbPaymentsButton.setBorderPainted(false);
        sbPaymentsButton.setContentAreaFilled(false);
        sbPaymentsButton.addActionListener(evt -> {
            if (currentPanel != null && !(currentPanel instanceof PaymentPanel)) {
                remove(currentPanel);
                currentPanel = new PaymentPanel(user, this);
                setDisplay(currentPanel);
            }
        });

        sbTaxCalculator.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\OptionPane-TaxCalculator.png"));
        sbTaxCalculator.setBorder(null);
        sbTaxCalculator.setBorderPainted(false);
        sbTaxCalculator.setContentAreaFilled(false);
        sbTaxCalculator.addActionListener(evt -> {
            if (currentPanel != null && !(currentPanel instanceof TaxCalculatorPanel)) {
                remove(currentPanel);
                currentPanel = new TaxCalculatorPanel(user, this);
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
                    .addComponent(sbProfileButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sbMessagesButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sbPaymentsButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sbTaxCalculator, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(sbProfileButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sbMessagesButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sbPaymentsButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sbTaxCalculator, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
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
            Constructor<?> ctor = clazz.getConstructor(User.class, Dashboard.class);
            Object object = ctor.newInstance(user, this);

            currentPanel = (JPanel) object;
            setDisplay(currentPanel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void logout() {
        Tabs.dashboard.dispose();
        if (Tabs.tabStartup != null) {
            Tabs.tabStartup.dispose();
        }
        Tabs.tabStartup = new TabStartup();
        Tabs.tabStartup.setVisible(true);
    }

    public static void main(String[] args) {
        Tabs.db = new DBConnection();
        User user = User.get(Tabs.db, "nathand123");
        String password = "password";
        System.out.println("Enter your password: " + password);
        if (user != null && user.checkPassword(password.trim())) {
            System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName());
            EventQueue.invokeLater(() -> new Dashboard(user).setVisible(true));
        }
    }
}