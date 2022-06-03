package a2.tabs.gui.view.main.panel;

import a2.tabs.gui.controller.Tabs;
import a2.tabs.gui.model.User;
import a2.tabs.gui.util.FormFieldType;
import a2.tabs.gui.view.main.TabsStartup;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

@SuppressWarnings({"FieldCanBeLocal", "ConstantConditions"})
public class Register extends JPanel {

    private final TabsStartup tabsStartup;

    private JTextField pgRegisterAddressInput;
    private JLabel pgRegisterAddressLabel;
    private JTextField pgRegisterCarRegoInput;
    private JLabel pgRegisterCarRegoLabel;
    private JTextField pgRegisterDateOfBirthInput;
    private JLabel pgRegisterDateOfBirthLabel;
    private JTextField pgRegisterEmailInput;
    private JLabel pgRegisterEmailLabel;
    private JTextField pgRegisterFirstNameInput;
    private JLabel pgRegisterFirstNameLabel;
    private JComboBox<String> pgRegisterHomeOwnerCombo;
    private JLabel pgRegisterHomeOwnerLabel;
    private JTextField pgRegisterIRDNumberInput;
    private JLabel pgRegisterIRDNumberLabel;
    private JTextField pgRegisterLastNameInput;
    private JLabel pgRegisterLastNameLabel;
    private JLabel pgRegisterLogoLabel;

    private JPasswordField pgRegisterPasswordInput;
    private JLabel pgRegisterPasswordLabel;
    private JTextField pgRegisterSalaryInput;
    private JLabel pgRegisterSalaryLabel;
    private JButton pgRegisterUpdateButton;
    private JTextField pgRegisterUsernameInput;
    private JLabel pgRegisterUsernameLabel;

    public Register(TabsStartup tabsStartup) {
        this.tabsStartup = tabsStartup;
        initComponents();
    }

    private void initComponents() {
        pgRegisterUsernameLabel = new JLabel();
        pgRegisterUsernameInput = new JTextField();
        pgRegisterFirstNameLabel = new JLabel();
        pgRegisterFirstNameInput = new JTextField();
        pgRegisterLastNameLabel = new JLabel();
        pgRegisterLastNameInput = new JTextField();
        pgRegisterDateOfBirthLabel = new JLabel();
        pgRegisterDateOfBirthInput = new JTextField();
        pgRegisterAddressLabel = new JLabel();
        pgRegisterAddressInput = new JTextField();
        pgRegisterIRDNumberLabel = new JLabel();
        pgRegisterIRDNumberInput = new JTextField();
        pgRegisterSalaryLabel = new JLabel();
        pgRegisterSalaryInput = new JTextField();
        pgRegisterCarRegoLabel = new JLabel();
        pgRegisterCarRegoInput = new JTextField();
        pgRegisterHomeOwnerLabel = new JLabel();
        pgRegisterHomeOwnerCombo = new JComboBox<>();
        pgRegisterEmailLabel = new JLabel();
        pgRegisterEmailInput = new JTextField();
        pgRegisterPasswordLabel = new JLabel();
        pgRegisterPasswordInput = new JPasswordField();
        pgRegisterUpdateButton = new JButton();
        pgRegisterLogoLabel = new JLabel();

        setForeground(new Color(246, 247, 251));

        pgRegisterUsernameLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgRegisterUsernameLabel.setForeground(new Color(153, 153, 153));
        pgRegisterUsernameLabel.setText("Username");

        pgRegisterUsernameInput.setBackground(new Color(204, 204, 204));
        pgRegisterUsernameInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        pgRegisterUsernameInput.setForeground(new Color(102, 102, 102));
        pgRegisterUsernameInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgRegisterUsernameInput.setCaretColor(new Color(102, 102, 102));
        pgRegisterUsernameInput.setOpaque(true);
        pgRegisterUsernameInput.setSelectionColor(new Color(252, 189, 27));

        pgRegisterFirstNameLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgRegisterFirstNameLabel.setForeground(new Color(153, 153, 153));
        pgRegisterFirstNameLabel.setText("First Name");

        pgRegisterFirstNameInput.setBackground(new Color(204, 204, 204));
        pgRegisterFirstNameInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        pgRegisterFirstNameInput.setForeground(new Color(102, 102, 102));
        pgRegisterFirstNameInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgRegisterFirstNameInput.setCaretColor(new Color(102, 102, 102));
        pgRegisterFirstNameInput.setOpaque(true);
        pgRegisterFirstNameInput.setSelectionColor(new Color(252, 189, 27));

        pgRegisterLastNameLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgRegisterLastNameLabel.setForeground(new Color(153, 153, 153));
        pgRegisterLastNameLabel.setText("Last Name");

        pgRegisterLastNameInput.setBackground(new Color(204, 204, 204));
        pgRegisterLastNameInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        pgRegisterLastNameInput.setForeground(new Color(102, 102, 102));
        pgRegisterLastNameInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgRegisterLastNameInput.setCaretColor(new Color(102, 102, 102));
        pgRegisterLastNameInput.setOpaque(true);
        pgRegisterLastNameInput.setSelectionColor(new Color(252, 189, 27));

        pgRegisterDateOfBirthLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgRegisterDateOfBirthLabel.setForeground(new Color(153, 153, 153));
        pgRegisterDateOfBirthLabel.setText("Date of Birth");

        pgRegisterDateOfBirthInput.setBackground(new Color(204, 204, 204));
        pgRegisterDateOfBirthInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        pgRegisterDateOfBirthInput.setForeground(new Color(102, 102, 102));
        pgRegisterDateOfBirthInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgRegisterDateOfBirthInput.setCaretColor(new Color(102, 102, 102));
        pgRegisterDateOfBirthInput.setOpaque(true);
        pgRegisterDateOfBirthInput.setSelectionColor(new Color(252, 189, 27));

        pgRegisterAddressLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgRegisterAddressLabel.setForeground(new Color(153, 153, 153));
        pgRegisterAddressLabel.setText("Address");

        pgRegisterAddressInput.setBackground(new Color(204, 204, 204));
        pgRegisterAddressInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        pgRegisterAddressInput.setForeground(new Color(102, 102, 102));
        pgRegisterAddressInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgRegisterAddressInput.setCaretColor(new Color(102, 102, 102));
        pgRegisterAddressInput.setOpaque(true);
        pgRegisterAddressInput.setSelectionColor(new Color(252, 189, 27));

        pgRegisterIRDNumberLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgRegisterIRDNumberLabel.setForeground(new Color(153, 153, 153));
        pgRegisterIRDNumberLabel.setText("IRD Number");

        pgRegisterIRDNumberInput.setBackground(new Color(204, 204, 204));
        pgRegisterIRDNumberInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        pgRegisterIRDNumberInput.setForeground(new Color(102, 102, 102));
        pgRegisterIRDNumberInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgRegisterIRDNumberInput.setCaretColor(new Color(102, 102, 102));
        pgRegisterIRDNumberInput.setOpaque(true);
        pgRegisterIRDNumberInput.setSelectionColor(new Color(252, 189, 27));

        pgRegisterSalaryLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgRegisterSalaryLabel.setForeground(new Color(153, 153, 153));
        pgRegisterSalaryLabel.setText("Salary");

        pgRegisterSalaryInput.setBackground(new Color(204, 204, 204));
        pgRegisterSalaryInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        pgRegisterSalaryInput.setForeground(new Color(102, 102, 102));
        pgRegisterSalaryInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgRegisterSalaryInput.setCaretColor(new Color(102, 102, 102));
        pgRegisterSalaryInput.setOpaque(true);
        pgRegisterSalaryInput.setSelectionColor(new Color(252, 189, 27));

        pgRegisterCarRegoLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgRegisterCarRegoLabel.setForeground(new Color(153, 153, 153));
        pgRegisterCarRegoLabel.setText("Car Registration");

        pgRegisterCarRegoInput.setBackground(new Color(204, 204, 204));
        pgRegisterCarRegoInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        pgRegisterCarRegoInput.setForeground(new Color(102, 102, 102));
        pgRegisterCarRegoInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgRegisterCarRegoInput.setCaretColor(new Color(102, 102, 102));
        pgRegisterCarRegoInput.setOpaque(true);
        pgRegisterCarRegoInput.setSelectionColor(new Color(252, 189, 27));

        pgRegisterHomeOwnerLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgRegisterHomeOwnerLabel.setForeground(new Color(153, 153, 153));
        pgRegisterHomeOwnerLabel.setText("Home Owner?");

        pgRegisterHomeOwnerCombo.setBackground(new Color(204, 204, 204));
        pgRegisterHomeOwnerCombo.setFont(new Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        pgRegisterHomeOwnerCombo.setForeground(new Color(102, 102, 102));
        pgRegisterHomeOwnerCombo.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgRegisterHomeOwnerCombo.setOpaque(true);

        pgRegisterHomeOwnerCombo.setFont(new Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        pgRegisterHomeOwnerCombo.setModel(new DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        pgRegisterHomeOwnerCombo.setBorder(null);

        pgRegisterEmailLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgRegisterEmailLabel.setForeground(new Color(153, 153, 153));
        pgRegisterEmailLabel.setText("Email");

        pgRegisterEmailInput.setBackground(new Color(204, 204, 204));
        pgRegisterEmailInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        pgRegisterEmailInput.setForeground(new Color(102, 102, 102));
        pgRegisterEmailInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgRegisterEmailInput.setCaretColor(new Color(102, 102, 102));
        pgRegisterEmailInput.setOpaque(true);
        pgRegisterEmailInput.setSelectionColor(new Color(252, 189, 27));

        pgRegisterPasswordLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgRegisterPasswordLabel.setForeground(new Color(153, 153, 153));
        pgRegisterPasswordLabel.setText("Password");

        pgRegisterPasswordInput.setBackground(new Color(204, 204, 204));
        pgRegisterPasswordInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        pgRegisterPasswordInput.setForeground(new Color(102, 102, 102));
        pgRegisterPasswordInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgRegisterPasswordInput.setCaretColor(new Color(102, 102, 102));
        pgRegisterPasswordInput.setOpaque(true);
        pgRegisterPasswordInput.setSelectionColor(new Color(252, 189, 27));

        pgRegisterUpdateButton.setBackground(new Color(0, 100, 172));
        pgRegisterUpdateButton.setFont(new Font("Bahnschrift", Font.BOLD, 18)); // NOI18N
        pgRegisterUpdateButton.setForeground(new Color(204, 204, 204));
        pgRegisterUpdateButton.setIcon(new ImageIcon("resources/image/RegisterPage-Submit.png")); // NOI18N
        pgRegisterUpdateButton.setBorder(null);
        pgRegisterUpdateButton.setBorderPainted(false);
        pgRegisterUpdateButton.setContentAreaFilled(false);
        pgRegisterUpdateButton.addActionListener(evt -> {
            // get username
            String username = pgRegisterUsernameInput.getText();
            if (!FormFieldType.USERNAME.isValid(username)) {
                pgRegisterUsernameInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "Username is invalid " + FormFieldType.USERNAME.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgRegisterUsernameInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            if (username.trim().equalsIgnoreCase("null") || username.trim().equalsIgnoreCase("admin")) {
                JOptionPane.showMessageDialog(null, "Username is invalid " + FormFieldType.USERNAME.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // get password
            String password = new String(pgRegisterPasswordInput.getPassword());
            if (password.length() < 8) {
                pgRegisterPasswordInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "Password is invalid (need 8 characters)", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgRegisterPasswordInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // get first name
            String firstName = pgRegisterFirstNameInput.getText();
            if (!FormFieldType.NAME.isValid(firstName)) {
                pgRegisterFirstNameInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "First name is invalid " + FormFieldType.NAME.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgRegisterFirstNameInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // get last name
            String lastName = pgRegisterLastNameInput.getText();
            if (!FormFieldType.NAME.isValid(lastName)) {
                pgRegisterLastNameInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "Last name is invalid " + FormFieldType.NAME.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgRegisterLastNameInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // get date of birth
            String dateOfBirth = pgRegisterDateOfBirthInput.getText();
            if (!FormFieldType.DATE.isValid(dateOfBirth)) {
                pgRegisterDateOfBirthInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "Date of birth is invalid " + FormFieldType.DATE.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgRegisterDateOfBirthInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // get address
            String address = pgRegisterAddressInput.getText();
            if (!FormFieldType.STRING.isValid(address)) {
                pgRegisterAddressInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "Address is invalid " + FormFieldType.STRING.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgRegisterAddressInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // get ird number
            String irdNumber = pgRegisterIRDNumberInput.getText();
            if (!FormFieldType.IRD_NUMBER.isValid(irdNumber)) {
                pgRegisterIRDNumberInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "IRD number is invalid " + FormFieldType.IRD_NUMBER.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgRegisterIRDNumberInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // get salary
            String salary = pgRegisterSalaryInput.getText();
            if (!FormFieldType.MONEY.isValid(salary)) {
                pgRegisterSalaryInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "Salary is invalid " + FormFieldType.MONEY.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgRegisterSalaryInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // get email
            String email = pgRegisterEmailInput.getText();
            if (!FormFieldType.EMAIL.isValid(email)) {
                pgRegisterEmailInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "Email is invalid " + FormFieldType.EMAIL.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgRegisterEmailInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // get car registration
            String carRego = pgRegisterCarRegoInput.getText();
            if (!FormFieldType.CAR_REGISTRATION.isValid(carRego)) {
                pgRegisterCarRegoInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "Car registration is invalid " + FormFieldType.CAR_REGISTRATION.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgRegisterCarRegoInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // get home owner
            String homeOwner = pgRegisterHomeOwnerCombo.getSelectedItem().toString();
            if (!FormFieldType.BOOLEAN.isValid(homeOwner)) {
                pgRegisterHomeOwnerCombo.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "Home owner is invalid " + FormFieldType.BOOLEAN.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgRegisterHomeOwnerCombo.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            String testDate = FormFieldType.DATE.getParsed(pgRegisterDateOfBirthInput.getText());
            String[] date = testDate.split("-");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            User user = new User(username, password, email, firstName, lastName, LocalDate.of(year, month, day), false);

            user.setOwnsHome(homeOwner.equalsIgnoreCase("yes"));
            if (address != null || !address.isEmpty()) {
                user.setAddress(address);
            }
            if (irdNumber != null || !irdNumber.isEmpty()) {
                user.setIrdNumber(irdNumber);
            }
            if (salary != null || !salary.isEmpty()) {
                user.setSalary(Double.parseDouble(salary));
            }
            if (carRego != null || !carRego.isEmpty()) {
                user.setCarRego(carRego);
            }

            user.push(Tabs.db);

            // show success message
            JOptionPane.showMessageDialog(this, "Successfully registered", "Success", JOptionPane.INFORMATION_MESSAGE);

            tabsStartup.remove(tabsStartup.currentPanel);
            tabsStartup.currentPanel = new Startup(tabsStartup);
            tabsStartup.setDisplay(tabsStartup.currentPanel);
        });

        pgRegisterLogoLabel.setIcon(new ImageIcon("resources/image/RegisterPage-Logo.png")); // NOI18N
        pgRegisterLogoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                tabsStartup.remove(tabsStartup.currentPanel);
                tabsStartup.currentPanel = new Startup(tabsStartup);
                tabsStartup.setDisplay(tabsStartup.currentPanel);
            }
        });

        GroupLayout pgRegisterPanelLayout = new GroupLayout(this);
        setLayout(pgRegisterPanelLayout);
        pgRegisterPanelLayout.setHorizontalGroup(
                pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgRegisterPanelLayout.createSequentialGroup()
                                .addGroup(pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(pgRegisterPanelLayout.createSequentialGroup()
                                                .addGap(152, 152, 152)
                                                .addGroup(pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(pgRegisterUpdateButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(pgRegisterPanelLayout.createSequentialGroup()
                                                                .addGroup(pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(pgRegisterAddressLabel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(pgRegisterPanelLayout.createSequentialGroup()
                                                                                .addGroup(pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(pgRegisterCarRegoInput, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(pgRegisterCarRegoLabel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(18, 18, Short.MAX_VALUE)
                                                                                .addGroup(pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(pgRegisterHomeOwnerLabel, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                                                                        .addComponent(pgRegisterHomeOwnerCombo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                        .addGroup(pgRegisterPanelLayout.createSequentialGroup()
                                                                                .addGroup(pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                                        .addComponent(pgRegisterUsernameLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(pgRegisterUsernameInput, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(46, 46, 46)
                                                                                .addGroup(pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                                        .addComponent(pgRegisterFirstNameLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(pgRegisterFirstNameInput, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))
                                                                        .addComponent(pgRegisterAddressInput, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(47, 47, 47)
                                                                .addGroup(pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(pgRegisterLastNameLabel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(pgRegisterLastNameInput, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(pgRegisterIRDNumberLabel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(pgRegisterIRDNumberInput, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(pgRegisterEmailInput, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(pgRegisterEmailLabel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(pgRegisterSalaryLabel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(pgRegisterSalaryInput, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(pgRegisterDateOfBirthLabel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(pgRegisterDateOfBirthInput, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(pgRegisterPasswordLabel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(pgRegisterPasswordInput, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(pgRegisterPanelLayout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(pgRegisterLogoLabel, GroupLayout.PREFERRED_SIZE, 1208, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(22, Short.MAX_VALUE))
        );
        pgRegisterPanelLayout.setVerticalGroup(
                pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgRegisterPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pgRegisterLogoLabel, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(pgRegisterPanelLayout.createSequentialGroup()
                                                        .addComponent(pgRegisterUsernameLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(pgRegisterUsernameInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(pgRegisterPanelLayout.createSequentialGroup()
                                                        .addComponent(pgRegisterFirstNameLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(pgRegisterFirstNameInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, pgRegisterPanelLayout.createSequentialGroup()
                                                        .addComponent(pgRegisterLastNameLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(pgRegisterLastNameInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(pgRegisterPanelLayout.createSequentialGroup()
                                                .addComponent(pgRegisterDateOfBirthLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(pgRegisterDateOfBirthInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(pgRegisterPanelLayout.createSequentialGroup()
                                                        .addComponent(pgRegisterAddressLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(pgRegisterAddressInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(pgRegisterPanelLayout.createSequentialGroup()
                                                        .addComponent(pgRegisterIRDNumberLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(pgRegisterIRDNumberInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(pgRegisterPanelLayout.createSequentialGroup()
                                                .addComponent(pgRegisterSalaryLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(pgRegisterSalaryInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pgRegisterPanelLayout.createSequentialGroup()
                                                .addGroup(pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, pgRegisterPanelLayout.createSequentialGroup()
                                                                .addComponent(pgRegisterCarRegoLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, pgRegisterPanelLayout.createSequentialGroup()
                                                                .addComponent(pgRegisterHomeOwnerLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)))
                                                .addGroup(pgRegisterPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(pgRegisterCarRegoInput, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                                        .addComponent(pgRegisterHomeOwnerCombo)))
                                        .addGroup(pgRegisterPanelLayout.createSequentialGroup()
                                                .addComponent(pgRegisterEmailLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(pgRegisterEmailInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pgRegisterPanelLayout.createSequentialGroup()
                                                .addComponent(pgRegisterPasswordLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(pgRegisterPasswordInput)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                .addComponent(pgRegisterUpdateButton)
                                .addGap(24, 24, 24))
        );
    }
}
