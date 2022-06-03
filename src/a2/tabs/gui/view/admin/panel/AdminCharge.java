package a2.tabs.gui.view.admin.panel;

import a2.tabs.gui.Tabs;
import a2.tabs.gui.model.Charge;
import a2.tabs.gui.model.User;
import a2.tabs.gui.model.util.ChargeType;
import a2.tabs.gui.view.admin.AdminDashboard;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

@SuppressWarnings("ConstantConditions")
public class AdminCharge extends JPanel {

    private final AdminDashboard adminDashboard;

    private JComboBox<String> pgUsersSelectInput;

    public AdminCharge(AdminDashboard adminDashboard) {
        this.adminDashboard = adminDashboard;
        initComponents();
        try {UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ignored) {}
    }

    private void initComponents() {
        JLabel pgUsersTitle = new JLabel();
        JLabel pgUsersSelectHeading = new JLabel();
        pgUsersSelectInput = new JComboBox<>();
        JLabel pgUsersDeleteHeading = new JLabel();
        JButton pgChargeBillsButton = new JButton();
        JLabel pgUsersDeleteHeading1 = new JLabel();
        JButton pgChargeFineSpeeding = new JButton();
        JButton pgChargeFineParking = new JButton();
        JLabel pgUsersDeleteHeading3 = new JLabel();
        JButton pgChargeFineRoad = new JButton();
        JLabel pgUsersDeleteHeading4 = new JLabel();

        setForeground(new Color(246, 247, 251));

        pgUsersTitle.setFont(new Font("Bahnschrift", Font.BOLD, 36));
        pgUsersTitle.setForeground(new Color(0, 100, 172));
        pgUsersTitle.setText("Charge Users");

        pgUsersSelectHeading.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgUsersSelectHeading.setForeground(new Color(153, 153, 153));
        pgUsersSelectHeading.setText("Select User");

        pgUsersSelectInput.setBackground(new Color(204, 204, 204));
        pgUsersSelectInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgUsersSelectInput.setForeground(new Color(102, 102, 102));
        pgUsersSelectInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgUsersSelectInput.setOpaque(true);

        java.util.List<String> users = new ArrayList<>();
        for (User user : User.get(Tabs.db)) {users.add(user.getUsername());}
        String[] userNames = new String[users.size()];
        pgUsersSelectInput.setModel(new DefaultComboBoxModel<>(users.toArray(userNames)));

        pgUsersDeleteHeading.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgUsersDeleteHeading.setForeground(new Color(153, 153, 153));
        pgUsersDeleteHeading.setText("Charge Bills");

        pgChargeBillsButton.setBackground(new Color(0, 100, 172));
        pgChargeBillsButton.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        pgChargeBillsButton.setForeground(new Color(204, 204, 204));
        pgChargeBillsButton.setIcon(new ImageIcon("resources/image/AdminChargeChargeButton-Charge.png"));
        pgChargeBillsButton.setBorder(null);
        pgChargeBillsButton.setBorderPainted(false);
        pgChargeBillsButton.setContentAreaFilled(false);
        pgChargeBillsButton.addActionListener(evt -> {
            User user = User.get(Tabs.db, pgUsersSelectInput.getSelectedItem().toString());
            LocalDate date = LocalDate.now();
            if (user.isOwnsHome()) {
                Charge charge1 = new Charge(ChargeType.ELECTRICITY_BILL, user, date, false);
                Charge charge2 = new Charge(ChargeType.WATER_BILL, user, date, false);
                Charge charge3 = new Charge(ChargeType.INTERNET_BILL, user, date, false);

                Tabs.db.push(charge1, charge2, charge3);
            }
            if (user.getCarRego() != null) {
                if (!user.getCarRego().equals("")) {
                    Charge charge4 = new Charge(ChargeType.ROAD_USER_CHARGES, user, date, false);
                    Tabs.db.push(charge4);
                }
            }

            // show success message
            JOptionPane.showMessageDialog(null, "Bills charged successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        pgUsersDeleteHeading1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgUsersDeleteHeading1.setForeground(new Color(153, 153, 153));
        pgUsersDeleteHeading1.setText("Speeding Fine");

        pgChargeFineSpeeding.setBackground(new Color(0, 100, 172));
        pgChargeFineSpeeding.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        pgChargeFineSpeeding.setForeground(new Color(204, 204, 204));
        pgChargeFineSpeeding.setIcon(new ImageIcon("resources/image/AdminChargeChargeButton-Charge.png"));
        pgChargeFineSpeeding.setBorder(null);
        pgChargeFineSpeeding.setBorderPainted(false);
        pgChargeFineSpeeding.setContentAreaFilled(false);
        pgChargeFineSpeeding.addActionListener(evt -> {
            User user = User.get(Tabs.db, pgUsersSelectInput.getSelectedItem().toString());
            LocalDate date = LocalDate.now();
            Charge charge = new Charge(ChargeType.SPEEDING_VIOLATION, user, date, false);
            Tabs.db.push(charge);

            // show success message
            JOptionPane.showMessageDialog(null, "Fine charged successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        pgChargeFineParking.setBackground(new Color(0, 100, 172));
        pgChargeFineParking.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        pgChargeFineParking.setForeground(new Color(204, 204, 204));
        pgChargeFineParking.setIcon(new ImageIcon("resources/image/AdminChargeChargeButton-Charge.png"));
        pgChargeFineParking.setBorder(null);
        pgChargeFineParking.setBorderPainted(false);
        pgChargeFineParking.setContentAreaFilled(false);
        pgChargeFineParking.addActionListener(evt -> {
            User user = User.get(Tabs.db, pgUsersSelectInput.getSelectedItem().toString());
            LocalDate date = LocalDate.now();
            Charge charge = new Charge(ChargeType.PARKING_VIOLATION, user, date, false);
            Tabs.db.push(charge);

            // show success message
            JOptionPane.showMessageDialog(null, "Fine charged successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        pgUsersDeleteHeading3.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgUsersDeleteHeading3.setForeground(new Color(153, 153, 153));
        pgUsersDeleteHeading3.setText("Parking Fine");

        pgChargeFineRoad.setBackground(new Color(0, 100, 172));
        pgChargeFineRoad.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        pgChargeFineRoad.setForeground(new Color(204, 204, 204));
        pgChargeFineRoad.setIcon(new ImageIcon("resources/image/AdminChargeChargeButton-Charge.png"));
        pgChargeFineRoad.setBorder(null);
        pgChargeFineRoad.setBorderPainted(false);
        pgChargeFineRoad.setContentAreaFilled(false);
        pgChargeFineRoad.addActionListener(evt -> {
            User user = User.get(Tabs.db, pgUsersSelectInput.getSelectedItem().toString());
            LocalDate date = LocalDate.now();
            Charge charge = new Charge(ChargeType.ROAD_VIOLATION, user, date, false);
            Tabs.db.push(charge);

            // show success message
            JOptionPane.showMessageDialog(null, "Fine charged successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        pgUsersDeleteHeading4.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgUsersDeleteHeading4.setForeground(new Color(153, 153, 153));
        pgUsersDeleteHeading4.setText("Road Violation");

        GroupLayout pgMessagesPanelLayout = new GroupLayout(this);
        setLayout(pgMessagesPanelLayout);
        pgMessagesPanelLayout.setHorizontalGroup(
            pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pgMessagesPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(pgChargeBillsButton, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pgUsersDeleteHeading, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pgUsersTitle, GroupLayout.PREFERRED_SIZE, 951, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pgUsersSelectHeading, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pgUsersSelectInput, GroupLayout.PREFERRED_SIZE, 936, GroupLayout.PREFERRED_SIZE)
                    .addGroup(pgMessagesPanelLayout.createSequentialGroup()
                        .addGroup(pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(pgChargeFineSpeeding, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                            .addComponent(pgUsersDeleteHeading1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(pgChargeFineParking, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                            .addComponent(pgUsersDeleteHeading3, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(pgChargeFineRoad, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                            .addComponent(pgUsersDeleteHeading4, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pgMessagesPanelLayout.setVerticalGroup(
            pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pgMessagesPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(pgUsersTitle, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pgUsersSelectHeading, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pgUsersSelectInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pgUsersDeleteHeading, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(pgMessagesPanelLayout.createSequentialGroup()
                        .addComponent(pgChargeBillsButton)
                        .addGap(18, 18, 18)
                        .addComponent(pgUsersDeleteHeading1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pgChargeFineSpeeding))
                    .addGroup(pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgMessagesPanelLayout.createSequentialGroup()
                            .addComponent(pgUsersDeleteHeading4, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pgChargeFineRoad))
                        .addGroup(pgMessagesPanelLayout.createSequentialGroup()
                            .addComponent(pgUsersDeleteHeading3, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pgChargeFineParking))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}
