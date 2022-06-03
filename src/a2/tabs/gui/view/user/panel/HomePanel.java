/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package a2.tabs.gui.view.user.panel;

import a2.tabs.gui.model.User;
import a2.tabs.gui.view.user.Dashboard;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("FieldCanBeLocal")
public class HomePanel extends JPanel {

    private final Dashboard dashboard;
    private final User user;

    private JLabel pgUsersSelectHeading;
    private JLabel pgUsersTitle;

    public HomePanel(User user, Dashboard dashboard) {
        this.user = user;
        this.dashboard = dashboard;
        initComponents();
        try {UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ignored) {}
    }

    private void initComponents() {
        pgUsersTitle = new JLabel();
        pgUsersSelectHeading = new JLabel();

        setForeground(new Color(246, 247, 251));

        pgUsersTitle.setFont(new Font("Bahnschrift", Font.BOLD, 36)); // NOI18N
        pgUsersTitle.setForeground(new Color(0, 100, 172));
        pgUsersTitle.setText("Welcome, " + user.getFirstName());

        pgUsersSelectHeading.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgUsersSelectHeading.setForeground(new Color(153, 153, 153));
        pgUsersSelectHeading.setText("Select an option from the left");

        GroupLayout pgMessagesPanelLayout = new GroupLayout(this);
        setLayout(pgMessagesPanelLayout);
        pgMessagesPanelLayout.setHorizontalGroup(
                pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgMessagesPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(pgUsersTitle, GroupLayout.PREFERRED_SIZE, 951, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pgUsersSelectHeading, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pgMessagesPanelLayout.setVerticalGroup(
                pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgMessagesPanelLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(pgUsersTitle, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pgUsersSelectHeading, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}
