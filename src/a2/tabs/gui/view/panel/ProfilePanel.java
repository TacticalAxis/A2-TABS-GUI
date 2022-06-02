package a2.tabs.gui.view.panel;

import a2.tabs.gui.model.User;
import a2.tabs.gui.util.FormFieldType;
import a2.tabs.gui.view.Dashboard;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;

@SuppressWarnings({"FieldCanBeLocal", "DuplicatedCode", "ConstantConditions"})
public class ProfilePanel extends JPanel {

    private final User user;
    private final Dashboard dashboard;

    private JLabel pgMessagesTitle;
    private JLabel pgProfileAddressLabel;
    private JTextField pgProfileAddressInput;
    private JLabel pgProfileCarRegoLabel;
    private JTextField pgProfileCarRegoInput;
    private JLabel pgProfileDateOfBirthLabel;
    private JTextField pgProfileDateOfBirthInput;
    private JLabel pgProfileEmailLabel;
    private JTextField pgProfileEmailInput;
    private JLabel pgProfileFirstNameLabel;
    private JTextField pgProfileFirstNameInput;
    private JLabel pgProfileHomeOwnerLabel;
    private JComboBox<String> pgProfileHomeOwnerInput;
    private JLabel pgProfileIRDNumberLabel;
    private JTextField pgProfileIRDNumberInput;
    private JLabel pgProfileLastNameLabel;
    private JTextField pgProfileLastNameInput;
    private JLabel pgProfilePasswordLabel;
    private JPasswordField pgProfilePasswordInput;
    private JLabel pgProfileSalaryLabel;
    private JTextField pgProfileSalaryInput;
    private JLabel pgProfileUsernameLabel;
    private JTextField pgProfileUsernameInput;
    private JButton pgProfileUpdateButton;

    public ProfilePanel(User user, Dashboard dashboard) {
        this.user = user;
        this.dashboard = dashboard;
        initComponents();
    }

    private void initComponents() {
        pgMessagesTitle = new JLabel();
        pgProfileUsernameLabel = new JLabel();
        pgProfileUsernameInput = new JTextField(user.getUsername());
        pgProfileFirstNameLabel = new JLabel();
        pgProfileFirstNameInput = new JTextField(user.getFirstName());
        pgProfileLastNameLabel = new JLabel();
        pgProfileLastNameInput = new JTextField(user.getLastName());
        pgProfileDateOfBirthLabel = new JLabel();

        LocalDate dateOfBirth = user.getDateOfBirth();

        pgProfileDateOfBirthInput = new JTextField(dateOfBirth.getDayOfMonth() + "-" + dateOfBirth.getMonthValue() + "-" + dateOfBirth.getYear());
        pgProfileAddressLabel = new JLabel();
        pgProfileAddressInput = new JTextField(user.getAddress());
        pgProfileIRDNumberLabel = new JLabel();
        pgProfileIRDNumberInput = new JTextField(user.getIrdNumber());
        pgProfileSalaryLabel = new JLabel();
        pgProfileSalaryInput = new JTextField(String.valueOf(user.getSalary()));
        pgProfileCarRegoLabel = new JLabel();
        pgProfileCarRegoInput = new JTextField(user.getCarRego());
        pgProfileHomeOwnerLabel = new JLabel();
        pgProfileHomeOwnerInput = new JComboBox<>(new String[]{"Yes", "No"});
        pgProfileHomeOwnerInput.setSelectedItem(user.isOwnsHome() ? "Yes" : "No");
        pgProfileEmailLabel = new JLabel();
        pgProfileEmailInput = new JTextField(user.getEmail());
        pgProfilePasswordLabel = new JLabel();
        pgProfilePasswordInput = new JPasswordField();
        pgProfileUpdateButton = new JButton();

        setForeground(new Color(246, 247, 251));

        pgMessagesTitle.setFont(new Font("Bahnschrift", Font.BOLD, 36));
        pgMessagesTitle.setForeground(new Color(0, 100, 172));
        pgMessagesTitle.setText("Profile");

        pgProfileUsernameLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgProfileUsernameLabel.setForeground(new Color(153, 153, 153));
        pgProfileUsernameLabel.setText("Username");

        pgProfileUsernameInput.setBackground(new Color(204, 204, 204));
        pgProfileUsernameInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgProfileUsernameInput.setForeground(new Color(102, 102, 102));
        pgProfileUsernameInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgProfileUsernameInput.setCaretColor(new Color(102, 102, 102));
        pgProfileUsernameInput.setOpaque(true);
        pgProfileUsernameInput.setSelectionColor(new Color(252, 189, 27));
        pgProfileUsernameInput.setEditable(false);
        pgProfileUsernameInput.setDisabledTextColor(new Color(148, 147, 147));
        pgProfileUsernameInput.setEnabled(false);

        pgProfileFirstNameLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgProfileFirstNameLabel.setForeground(new Color(153, 153, 153));
        pgProfileFirstNameLabel.setText("First Name");

        pgProfileFirstNameInput.setBackground(new Color(204, 204, 204));
        pgProfileFirstNameInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgProfileFirstNameInput.setForeground(new Color(102, 102, 102));
        pgProfileFirstNameInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgProfileFirstNameInput.setCaretColor(new Color(102, 102, 102));
        pgProfileFirstNameInput.setOpaque(true);
        pgProfileFirstNameInput.setSelectionColor(new Color(252, 189, 27));

        pgProfileLastNameLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgProfileLastNameLabel.setForeground(new Color(153, 153, 153));
        pgProfileLastNameLabel.setText("Last Name");

        pgProfileLastNameInput.setBackground(new Color(204, 204, 204));
        pgProfileLastNameInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgProfileLastNameInput.setForeground(new Color(102, 102, 102));
        pgProfileLastNameInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgProfileLastNameInput.setCaretColor(new Color(102, 102, 102));
        pgProfileLastNameInput.setOpaque(true);
        pgProfileLastNameInput.setSelectionColor(new Color(252, 189, 27));

        pgProfileDateOfBirthLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgProfileDateOfBirthLabel.setForeground(new Color(153, 153, 153));
        pgProfileDateOfBirthLabel.setText("Date of Birth");

        pgProfileDateOfBirthInput.setBackground(new Color(204, 204, 204));
        pgProfileDateOfBirthInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgProfileDateOfBirthInput.setForeground(new Color(102, 102, 102));
        pgProfileDateOfBirthInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgProfileDateOfBirthInput.setCaretColor(new Color(102, 102, 102));
        pgProfileDateOfBirthInput.setOpaque(true);
        pgProfileDateOfBirthInput.setSelectionColor(new Color(252, 189, 27));

        pgProfileAddressLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgProfileAddressLabel.setForeground(new Color(153, 153, 153));
        pgProfileAddressLabel.setText("Address");

        pgProfileAddressInput.setBackground(new Color(204, 204, 204));
        pgProfileAddressInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgProfileAddressInput.setForeground(new Color(102, 102, 102));
        pgProfileAddressInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgProfileAddressInput.setCaretColor(new Color(102, 102, 102));
        pgProfileAddressInput.setOpaque(true);
        pgProfileAddressInput.setSelectionColor(new Color(252, 189, 27));

        pgProfileIRDNumberLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgProfileIRDNumberLabel.setForeground(new Color(153, 153, 153));
        pgProfileIRDNumberLabel.setText("IRD Number");

        pgProfileIRDNumberInput.setBackground(new Color(204, 204, 204));
        pgProfileIRDNumberInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgProfileIRDNumberInput.setForeground(new Color(102, 102, 102));
        pgProfileIRDNumberInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgProfileIRDNumberInput.setCaretColor(new Color(102, 102, 102));
        pgProfileIRDNumberInput.setOpaque(true);
        pgProfileIRDNumberInput.setSelectionColor(new Color(252, 189, 27));

        pgProfileSalaryLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgProfileSalaryLabel.setForeground(new Color(153, 153, 153));
        pgProfileSalaryLabel.setText("Salary");

        pgProfileSalaryInput.setBackground(new Color(204, 204, 204));
        pgProfileSalaryInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgProfileSalaryInput.setForeground(new Color(102, 102, 102));
        pgProfileSalaryInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgProfileSalaryInput.setCaretColor(new Color(102, 102, 102));
        pgProfileSalaryInput.setOpaque(true);
        pgProfileSalaryInput.setSelectionColor(new Color(252, 189, 27));

        pgProfileCarRegoLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgProfileCarRegoLabel.setForeground(new Color(153, 153, 153));
        pgProfileCarRegoLabel.setText("Car Registration");

        pgProfileCarRegoInput.setBackground(new Color(204, 204, 204));
        pgProfileCarRegoInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgProfileCarRegoInput.setForeground(new Color(102, 102, 102));
        pgProfileCarRegoInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgProfileCarRegoInput.setCaretColor(new Color(102, 102, 102));
        pgProfileCarRegoInput.setOpaque(true);
        pgProfileCarRegoInput.setSelectionColor(new Color(252, 189, 27));

        pgProfileHomeOwnerLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgProfileHomeOwnerLabel.setForeground(new Color(153, 153, 153));
        pgProfileHomeOwnerLabel.setText("Home Owner?");

        pgProfileHomeOwnerInput.setBackground(new Color(204, 204, 204));
        pgProfileHomeOwnerInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgProfileHomeOwnerInput.setForeground(new Color(102, 102, 102));
        pgProfileHomeOwnerInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
//        pgProfileHomeOwnerInput.setCaretColor(new Color(102, 102, 102));
        pgProfileHomeOwnerInput.setOpaque(true);
//        pgProfileHomeOwnerInput.setSelectionColor(new Color(252, 189, 27));

        pgProfileEmailLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgProfileEmailLabel.setForeground(new Color(153, 153, 153));
        pgProfileEmailLabel.setText("Email");

        pgProfileEmailInput.setBackground(new Color(204, 204, 204));
        pgProfileEmailInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgProfileEmailInput.setForeground(new Color(102, 102, 102));
        pgProfileEmailInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgProfileEmailInput.setCaretColor(new Color(102, 102, 102));
        pgProfileEmailInput.setOpaque(true);
        pgProfileEmailInput.setSelectionColor(new Color(252, 189, 27));

        pgProfilePasswordLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgProfilePasswordLabel.setForeground(new Color(153, 153, 153));
        pgProfilePasswordLabel.setText("Password");

        pgProfilePasswordInput.setBackground(new Color(204, 204, 204));
        pgProfilePasswordInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgProfilePasswordInput.setForeground(new Color(102, 102, 102));
        pgProfilePasswordInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgProfilePasswordInput.setCaretColor(new Color(102, 102, 102));
        pgProfilePasswordInput.setOpaque(true);
        pgProfilePasswordInput.setSelectionColor(new Color(252, 189, 27));

        pgProfileUpdateButton.setBackground(new Color(0, 100, 172));
        pgProfileUpdateButton.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        pgProfileUpdateButton.setForeground(new Color(204, 204, 204));
        pgProfileUpdateButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\ProfilePane-UpdateButton.png"));
        pgProfileUpdateButton.setBorder(null);
        pgProfileUpdateButton.setBorderPainted(false);
        pgProfileUpdateButton.setContentAreaFilled(false);
        pgProfileUpdateButton.addActionListener(evt -> {

            // check firstName
            if (!FormFieldType.NAME.isValid(pgProfileFirstNameInput.getText())) {
                pgProfileFirstNameInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "First Name is invalid. Format: " + FormFieldType.NAME.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgProfileFirstNameInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // check lastName
            if (!FormFieldType.NAME.isValid(pgProfileLastNameInput.getText())) {
                pgProfileLastNameInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "Last Name is invalid. Format: " + FormFieldType.NAME.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgProfileLastNameInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // check dateOfBirth
            if (!FormFieldType.DATE.isValid(pgProfileDateOfBirthInput.getText())) {
                pgProfileDateOfBirthInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "Date of Birth is invalid. Format: " + FormFieldType.DATE.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgProfileDateOfBirthInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // check address
            if (!FormFieldType.STRING.isValid(pgProfileAddressInput.getText())) {
                pgProfileAddressInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "Address is invalid. Format: " + FormFieldType.STRING.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgProfileAddressInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // check irdNumber
            if (!FormFieldType.IRD_NUMBER.isValid(pgProfileIRDNumberInput.getText())) {
                pgProfileIRDNumberInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "IRD Number is invalid. Format: " + FormFieldType.IRD_NUMBER.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgProfileIRDNumberInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // check salary
            if (!FormFieldType.MONEY.isValid(pgProfileSalaryInput.getText())) {
                pgProfileSalaryInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "Salary is invalid. Format: " + FormFieldType.MONEY.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgProfileSalaryInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // check carRego
            if (!FormFieldType.CAR_REGISTRATION.isValid(pgProfileCarRegoInput.getText())) {
                pgProfileCarRegoInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "Car Registration is invalid. Format: " + FormFieldType.CAR_REGISTRATION.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgProfileCarRegoInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // check homeOwner
            if (!FormFieldType.BOOLEAN.isValid(pgProfileHomeOwnerInput.getSelectedItem().toString())) {
                pgProfileHomeOwnerInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "Home Owner is invalid. Format: " + FormFieldType.BOOLEAN.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgProfileHomeOwnerInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // check email
            if (!FormFieldType.EMAIL.isValid(pgProfileEmailInput.getText())) {
                pgProfileEmailInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "Email is invalid. Format: " + FormFieldType.EMAIL.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgProfileEmailInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // check password
            if (!FormFieldType.STRING.isValid(pgProfilePasswordInput.getText())) {
                pgProfilePasswordInput.setBorder(new LineBorder(Color.RED, 5, true));
                JOptionPane.showMessageDialog(null, "Password is invalid. Format: " + FormFieldType.STRING.getFormat(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                pgProfilePasswordInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
            }

            // all fields are valid
            user.setFirstName(pgProfileFirstNameInput.getText());
            user.setLastName(pgProfileLastNameInput.getText());

            // set dateOfBirth
            String testDate = FormFieldType.DATE.getParsed(pgProfileDateOfBirthInput.getText());
            String[] date = testDate.split("-");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            user.setDateOfBirth(LocalDate.of(year, month, day));

            user.setAddress(pgProfileAddressInput.getText());
            user.setIrdNumber(pgProfileIRDNumberInput.getText());
            user.setSalary(Double.parseDouble(pgProfileSalaryInput.getText()));
            user.setCarRego(pgProfileCarRegoInput.getText());
            user.setOwnsHome(pgProfileHomeOwnerInput.getSelectedItem().toString().equalsIgnoreCase("yes"));
            user.setEmail(pgProfileEmailInput.getText());
            for (User u : User.get(Dashboard.db)) {
                if (u.getEmail().equalsIgnoreCase(user.getEmail()) && !(u.userEquals(user))) {
                    pgProfileEmailInput.setBorder(new LineBorder(Color.RED, 5, true));
                    JOptionPane.showMessageDialog(null, "Email already exists", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            if (!String.valueOf(pgProfilePasswordInput.getPassword()).equals("")) {
                user.setPassword(String.valueOf(pgProfilePasswordInput.getPassword()));
                pgProfilePasswordInput.setText("");
            }

            // update user
            if (user.equals(User.get(Dashboard.db, user.getUsername()))) {
                return;
            }

            user.push(Dashboard.db);

            // show dialog
            JOptionPane.showMessageDialog(null, "Profile updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        GroupLayout pgProfilePanelLayout = new GroupLayout(this);
        setLayout(pgProfilePanelLayout);
        pgProfilePanelLayout.setHorizontalGroup(
                pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgProfilePanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pgMessagesTitle, GroupLayout.PREFERRED_SIZE, 951, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, pgProfilePanelLayout.createSequentialGroup()
                                                .addGroup(pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(pgProfileUpdateButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(pgProfilePanelLayout.createSequentialGroup()
                                                                .addGroup(pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(pgProfileAddressLabel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(pgProfilePanelLayout.createSequentialGroup()
                                                                                .addGroup(pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(pgProfileCarRegoInput, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(pgProfileCarRegoLabel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(18, 48, Short.MAX_VALUE)
                                                                                .addGroup(pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(pgProfileHomeOwnerLabel, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                                                                        .addComponent(pgProfileHomeOwnerInput)))
                                                                        .addGroup(pgProfilePanelLayout.createSequentialGroup()
                                                                                .addGroup(pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                                        .addComponent(pgProfileUsernameLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                                                                        .addComponent(pgProfileUsernameInput, GroupLayout.Alignment.LEADING))
                                                                                .addGap(46, 46, 46)
                                                                                .addGroup(pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                                        .addComponent(pgProfileFirstNameLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(pgProfileFirstNameInput, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))
                                                                        .addComponent(pgProfileAddressInput))
                                                                .addGap(47, 47, 47)
                                                                .addGroup(pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(pgProfileLastNameLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(pgProfileLastNameInput, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(pgProfileIRDNumberLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(pgProfileIRDNumberInput, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(pgProfileEmailInput, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(pgProfileEmailLabel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(pgProfileSalaryLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(pgProfileSalaryInput, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                                                        .addComponent(pgProfileDateOfBirthLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(pgProfileDateOfBirthInput, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                                                        .addComponent(pgProfilePasswordLabel, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                                                        .addComponent(pgProfilePasswordInput))))
                                                .addGap(24, 24, 24)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pgProfilePanelLayout.setVerticalGroup(
                pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgProfilePanelLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(pgMessagesTitle, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(pgProfilePanelLayout.createSequentialGroup()
                                                        .addComponent(pgProfileUsernameLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(pgProfileUsernameInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(pgProfilePanelLayout.createSequentialGroup()
                                                        .addComponent(pgProfileFirstNameLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(pgProfileFirstNameInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, pgProfilePanelLayout.createSequentialGroup()
                                                        .addComponent(pgProfileLastNameLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(pgProfileLastNameInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(pgProfilePanelLayout.createSequentialGroup()
                                                .addComponent(pgProfileDateOfBirthLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(pgProfileDateOfBirthInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(pgProfilePanelLayout.createSequentialGroup()
                                                        .addComponent(pgProfileAddressLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(pgProfileAddressInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(pgProfilePanelLayout.createSequentialGroup()
                                                        .addComponent(pgProfileIRDNumberLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(pgProfileIRDNumberInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(pgProfilePanelLayout.createSequentialGroup()
                                                .addComponent(pgProfileSalaryLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(pgProfileSalaryInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pgProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(pgProfilePanelLayout.createSequentialGroup()
                                                        .addComponent(pgProfileCarRegoLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(pgProfileCarRegoInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(pgProfilePanelLayout.createSequentialGroup()
                                                        .addComponent(pgProfileHomeOwnerLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(pgProfileHomeOwnerInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(pgProfilePanelLayout.createSequentialGroup()
                                                .addComponent(pgProfileEmailLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(pgProfileEmailInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pgProfilePanelLayout.createSequentialGroup()
                                                .addComponent(pgProfilePasswordLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(pgProfilePasswordInput)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pgProfileUpdateButton)
                                .addGap(24, 24, 24))
        );
    }
}