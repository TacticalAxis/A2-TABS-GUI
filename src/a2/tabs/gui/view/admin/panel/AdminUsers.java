package a2.tabs.gui.view.admin.panel;

import a2.tabs.gui.Tabs;
import a2.tabs.gui.model.User;
import a2.tabs.gui.view.admin.AdminDashboard;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class AdminUsers extends JPanel {

    private final AdminDashboard adminDashboard;

    private JComboBox<String> pgUsersSelectInput;

    public AdminUsers(AdminDashboard adminDashboard) {
        this.adminDashboard = adminDashboard;
        initComponents();
        try {UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ignored) {}
    }

    private void initComponents() {
        JLabel pgUsersTitle = new JLabel();
        JLabel pgUsersSelectHeading = new JLabel();
        pgUsersSelectInput = new JComboBox<>();
        JLabel pgUsersDeleteHeading = new JLabel();
        JButton pgUsersDeleteButton = new JButton();

        setForeground(new Color(246, 247, 251));

        pgUsersTitle.setFont(new Font("Bahnschrift", Font.BOLD, 36));
        pgUsersTitle.setForeground(new Color(0, 100, 172));
        pgUsersTitle.setText("Manage Users");

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
        pgUsersDeleteHeading.setText("Delete?");

        pgUsersDeleteButton.setBackground(new Color(0, 100, 172));
        pgUsersDeleteButton.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        pgUsersDeleteButton.setForeground(new Color(204, 204, 204));
        pgUsersDeleteButton.setIcon(new ImageIcon("resources/image/AdminDeleteButton-Delete.png"));
        pgUsersDeleteButton.setBorder(null);
        pgUsersDeleteButton.setBorderPainted(false);
        pgUsersDeleteButton.setContentAreaFilled(false);
        pgUsersDeleteButton.addActionListener(evt -> {
            if (pgUsersSelectInput.getItemCount() > 0) {
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
                    User user = User.get(Tabs.db, (String) pgUsersSelectInput.getSelectedItem());
                    if (user != null) {
                        user.delete(Tabs.db);
                        adminDashboard.refreshCurrentPanel();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "No users to delete");
            }
        });

        GroupLayout pgMessagesPanelLayout = new GroupLayout(this);
        setLayout(pgMessagesPanelLayout);
        pgMessagesPanelLayout.setHorizontalGroup(
            pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pgMessagesPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(pgUsersDeleteButton, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pgUsersDeleteHeading, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pgUsersTitle, GroupLayout.PREFERRED_SIZE, 951, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pgUsersSelectHeading, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pgUsersSelectInput, GroupLayout.PREFERRED_SIZE, 936, GroupLayout.PREFERRED_SIZE))
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
                .addComponent(pgUsersDeleteButton)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}