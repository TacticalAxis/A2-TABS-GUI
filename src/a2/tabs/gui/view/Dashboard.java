package a2.tabs.gui.view;

import a2.tabs.gui.database.DBConnection;
import a2.tabs.gui.model.User;
import a2.tabs.gui.view.panel.*;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings({"DuplicatedCode", "FieldCanBeLocal"})
public class Dashboard extends JFrame {

    public static DBConnection db;

    private final User user;

    private JPanel currentPanel;

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
        currentPanel = new HomePanel(user);

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
                currentPanel = new HomePanel(user);
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

        sbExitButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\Menu-Exit.png"));
        sbExitButton.setBorder(null);
        sbExitButton.setBorderPainted(false);
        sbExitButton.setContentAreaFilled(false);
        sbExitButton.setFocusPainted(false);
        sbExitButton.setMaximumSize(new Dimension(75, 75));
        sbExitButton.setMinimumSize(new Dimension(75, 75));
        sbExitButton.addActionListener(evt -> {
            System.out.println("Exit");
            System.exit(0);
        });

        sbProfileButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\OptionPane-Profile.png"));
        sbProfileButton.setBorder(null);
        sbProfileButton.setBorderPainted(false);
        sbProfileButton.setContentAreaFilled(false);
        sbProfileButton.addActionListener(evt -> {
            if (currentPanel != null && !(currentPanel instanceof ProfilePanel)) {
                remove(currentPanel);
                currentPanel = new ProfilePanel(user);
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
                currentPanel = new MessagePanel(user);
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
                currentPanel = new PaymentPanel(user);
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
                currentPanel = new TaxCalculatorPanel();
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

    private void setDisplay(JPanel panel) {

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

    public static void main(String[] args) {
        db = new DBConnection();
        User user = User.get(db, "nathand123");
        EventQueue.invokeLater(() -> new Dashboard(user).setVisible(true));
    }
}