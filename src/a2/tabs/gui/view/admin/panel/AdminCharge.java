/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package a2.tabs.gui.view.admin.panel;

import a2.tabs.gui.controller.Tabs;
import a2.tabs.gui.model.Charge;
import a2.tabs.gui.model.User;
import a2.tabs.gui.model.util.ChargeType;
import a2.tabs.gui.view.admin.AdminDashboard;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

@SuppressWarnings({"FieldCanBeLocal", "ConstantConditions"})
public class AdminCharge extends JPanel {

    private final AdminDashboard adminDashboard;

    private JButton pgChargeBillsButton;
    private JButton pgChargeFineSpeeding;
    private JButton pgChargeFineParking;
    private JButton pgChargeFineRoad;
    private JLabel pgUsersDeleteHeading;
    private JLabel pgUsersDeleteHeading1;
    private JLabel pgUsersDeleteHeading3;
    private JLabel pgUsersDeleteHeading4;
    private JLabel pgUsersSelectHeading;
    private JComboBox<String> pgUsersSelectInput;
    private JLabel pgUsersTitle;

    public AdminCharge(AdminDashboard adminDashboard) {
        this.adminDashboard = adminDashboard;
        initComponents();
        try {UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ignored) {}
    }

    private void initComponents() {
        pgUsersTitle = new JLabel();
        pgUsersSelectHeading = new JLabel();
        pgUsersSelectInput = new JComboBox<>();
        pgUsersDeleteHeading = new JLabel();
        pgChargeBillsButton = new JButton();
        pgUsersDeleteHeading1 = new JLabel();
        pgChargeFineSpeeding = new JButton();
        pgChargeFineParking = new JButton();
        pgUsersDeleteHeading3 = new JLabel();
        pgChargeFineRoad = new JButton();
        pgUsersDeleteHeading4 = new JLabel();

        setForeground(new java.awt.Color(246, 247, 251));

        pgUsersTitle.setFont(new java.awt.Font("Bahnschrift", Font.BOLD, 36)); // NOI18N
        pgUsersTitle.setForeground(new java.awt.Color(0, 100, 172));
        pgUsersTitle.setText("Charge Users");

        pgUsersSelectHeading.setFont(new java.awt.Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgUsersSelectHeading.setForeground(new java.awt.Color(153, 153, 153));
        pgUsersSelectHeading.setText("Select User");

        pgUsersSelectInput.setBackground(new java.awt.Color(204, 204, 204));
        pgUsersSelectInput.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        pgUsersSelectInput.setForeground(new java.awt.Color(102, 102, 102));
        pgUsersSelectInput.setBorder(new LineBorder(new java.awt.Color(204, 204, 204), 5, true));
        pgUsersSelectInput.setOpaque(true);

        java.util.List<String> users = new ArrayList<>();
        for (User user : User.get(Tabs.db)) {users.add(user.getUsername());}
        String[] userNames = new String[users.size()];
        pgUsersSelectInput.setModel(new DefaultComboBoxModel<>(users.toArray(userNames)));

        pgUsersDeleteHeading.setFont(new java.awt.Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgUsersDeleteHeading.setForeground(new java.awt.Color(153, 153, 153));
        pgUsersDeleteHeading.setText("Charge Bills");

        pgChargeBillsButton.setBackground(new java.awt.Color(0, 100, 172));
        pgChargeBillsButton.setFont(new java.awt.Font("Bahnschrift", Font.BOLD, 18)); // NOI18N
        pgChargeBillsButton.setForeground(new java.awt.Color(204, 204, 204));
        pgChargeBillsButton.setIcon(new ImageIcon("resources/imageAdminChargeChargeButton-Charge.png")); // NOI18N
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

        pgUsersDeleteHeading1.setFont(new java.awt.Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgUsersDeleteHeading1.setForeground(new java.awt.Color(153, 153, 153));
        pgUsersDeleteHeading1.setText("Speeding Fine");

        pgChargeFineSpeeding.setBackground(new java.awt.Color(0, 100, 172));
        pgChargeFineSpeeding.setFont(new java.awt.Font("Bahnschrift", Font.BOLD, 18)); // NOI18N
        pgChargeFineSpeeding.setForeground(new java.awt.Color(204, 204, 204));
        pgChargeFineSpeeding.setIcon(new ImageIcon("resources/imageAdminChargeChargeButton-Charge.png")); // NOI18N
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

        pgChargeFineParking.setBackground(new java.awt.Color(0, 100, 172));
        pgChargeFineParking.setFont(new java.awt.Font("Bahnschrift", Font.BOLD, 18)); // NOI18N
        pgChargeFineParking.setForeground(new java.awt.Color(204, 204, 204));
        pgChargeFineParking.setIcon(new ImageIcon("resources/imageAdminChargeChargeButton-Charge.png")); // NOI18N
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

        pgUsersDeleteHeading3.setFont(new java.awt.Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgUsersDeleteHeading3.setForeground(new java.awt.Color(153, 153, 153));
        pgUsersDeleteHeading3.setText("Parking Fine");

        pgChargeFineRoad.setBackground(new java.awt.Color(0, 100, 172));
        pgChargeFineRoad.setFont(new java.awt.Font("Bahnschrift", Font.BOLD, 18)); // NOI18N
        pgChargeFineRoad.setForeground(new java.awt.Color(204, 204, 204));
        pgChargeFineRoad.setIcon(new ImageIcon("resources/imageAdminChargeChargeButton-Charge.png")); // NOI18N
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

        pgUsersDeleteHeading4.setFont(new java.awt.Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgUsersDeleteHeading4.setForeground(new java.awt.Color(153, 153, 153));
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
