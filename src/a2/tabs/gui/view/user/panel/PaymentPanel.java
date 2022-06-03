package a2.tabs.gui.view.user.panel;

import a2.tabs.gui.controller.Tabs;
import a2.tabs.gui.model.Charge;
import a2.tabs.gui.model.User;
import a2.tabs.gui.view.user.Dashboard;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

@SuppressWarnings("FieldCanBeLocal")
public class PaymentPanel extends JPanel {

    private final User user;
    private final Dashboard dashboard;

    private JLabel pgPaymentHistoryLabel;
    private JList<String> pgPaymentHistoryList;
    private JScrollPane pgPaymentHistoryScroll;
    private JLabel pgPaymentTitle;
    private JLabel pgPaymentUpcomingLabel;
    private JList<String> pgPaymentUpcomingList;
    private JScrollPane pgPaymentUpcomingScroll;

    public PaymentPanel(User user, Dashboard dashboard) {
        this.user = user;
        this.dashboard = dashboard;
        initComponents();
    }

    private void initComponents() {
        pgPaymentTitle = new JLabel();
        pgPaymentUpcomingLabel = new JLabel();
        pgPaymentUpcomingScroll = new JScrollPane();
        pgPaymentUpcomingList = new JList<>();
        pgPaymentHistoryLabel = new JLabel();
        pgPaymentHistoryScroll = new JScrollPane();
        pgPaymentHistoryList = new JList<>();

        setForeground(new Color(246, 247, 251));

        pgPaymentTitle.setFont(new Font("Bahnschrift", Font.BOLD, 36));
        pgPaymentTitle.setForeground(new Color(0, 100, 172));
        pgPaymentTitle.setText("Payments");

        pgPaymentUpcomingLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgPaymentUpcomingLabel.setForeground(new Color(153, 153, 153));
        pgPaymentUpcomingLabel.setText("Upcoming Payments");

        pgPaymentUpcomingList.setBackground(new Color(204, 204, 204));
        pgPaymentUpcomingList.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgPaymentUpcomingList.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgPaymentUpcomingList.setForeground(new Color(102, 102, 102));
        setPgPaymentUpcomingList();



        pgPaymentHistoryLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgPaymentHistoryLabel.setForeground(new Color(153, 153, 153));
        pgPaymentHistoryLabel.setText("Payment History");

        pgPaymentHistoryList.setBackground(new Color(204, 204, 204));
        pgPaymentHistoryList.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgPaymentHistoryList.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgPaymentHistoryList.setForeground(new Color(102, 102, 102));
        setPgPaymentHistoryList();

        GroupLayout pgPaymentsPanelLayout = new GroupLayout(this);
        setLayout(pgPaymentsPanelLayout);
        pgPaymentsPanelLayout.setHorizontalGroup(
                pgPaymentsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgPaymentsPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(pgPaymentsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(pgPaymentsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(pgPaymentTitle, GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
                                                .addComponent(pgPaymentUpcomingLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(pgPaymentHistoryLabel, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pgPaymentsPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(pgPaymentHistoryScroll, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
                                                .addComponent(pgPaymentUpcomingScroll, GroupLayout.Alignment.LEADING)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pgPaymentsPanelLayout.setVerticalGroup(
                pgPaymentsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgPaymentsPanelLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(pgPaymentTitle, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pgPaymentUpcomingLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pgPaymentUpcomingScroll, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(pgPaymentHistoryLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pgPaymentHistoryScroll, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
        );
    }

    private void setPgPaymentUpcomingList() {
        java.util.List<Charge> charges = Charge.get(Tabs.db, user, false);
        final String[] chargeStrings = new String[charges.size()];
        for (int i = 0; i < charges.size(); i++) {
            StringBuilder sb = new StringBuilder();
            // append date
            sb.append("[");
            LocalDate date = charges.get(i).getDate();
            String dateString = (date.getDayOfMonth() < 10 ? "0" : "") + date.getDayOfMonth() + "-" + (date.getMonthValue() < 10 ? "0" : "") + date.getMonthValue() + "-" + date.getYear();

            sb.append(dateString);
            sb.append("] - ");

            // append amount
            sb.append("( $");
            sb.append(charges.get(i).getType().getAmount());
            sb.append(" ): ");

            // append type
            sb.append(charges.get(i).getType().getName());

            // append if overdue
            if (charges.get(i).isOverdue()) {
                sb.append(" (OVERDUE)");
            }

            chargeStrings[i] = sb.toString();
        }

        pgPaymentUpcomingList.setModel(new AbstractListModel<String>() {
            final String[] strings = chargeStrings;
            public int getSize() {
                return strings.length;
            }
            public String getElementAt(int i) {
                return strings[i];
            }
        });

        pgPaymentUpcomingList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                pgPaymentHistoryList.clearSelection();
                if (evt.getClickCount() == 2) {
                    int index = pgPaymentUpcomingList.locationToIndex(evt.getPoint());
                    if (index >= 0) {
                        Charge charge = charges.get(index);
                        String[] options = {"Pay Now", "Cancel"};
                        int result = JOptionPane.showOptionDialog(
                                null,
                                charge.toStringFancy(),
                                "Payment",
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
                            charge.setPaid(true);
                            charge.push(Tabs.db);
                            dashboard.refreshCurrentPanel();
                        }
                    }
                }
            }
        });

        pgPaymentUpcomingList.setSelectionBackground(new Color(252, 189, 27));
        pgPaymentUpcomingScroll.setViewportView(pgPaymentUpcomingList);
    }

    private void setPgPaymentHistoryList() {
        java.util.List<Charge> charges = Charge.get(Tabs.db, user, true);
        final String[] chargeStrings = new String[charges.size()];
        for (int i = 0; i < charges.size(); i++) {
            StringBuilder sb = new StringBuilder();
            // append date
            sb.append("[");
            LocalDate date = charges.get(i).getDate();
            String dateString = (date.getDayOfMonth() < 10 ? "0" : "") + date.getDayOfMonth() + "-" + (date.getMonthValue() < 10 ? "0" : "") + date.getMonthValue() + "-" + date.getYear();

            sb.append(dateString);
            sb.append("] - ");

            // append amount
            sb.append("( $");
            sb.append(charges.get(i).getType().getAmount());
            sb.append(" ): ");

            // append type
            sb.append(charges.get(i).getType().getName());

            chargeStrings[i] = sb.toString();
        }

        pgPaymentHistoryList.setModel(new AbstractListModel<String>() {
            final String[] strings = chargeStrings;
            public int getSize() {
                return strings.length;
            }
            public String getElementAt(int i) {
                return strings[i];
            }
        });

        pgPaymentHistoryList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                pgPaymentUpcomingList.clearSelection();
                if (evt.getClickCount() == 2) {
                    int index = pgPaymentHistoryList.locationToIndex(evt.getPoint());
                    if (index >= 0) {
                        Charge charge = charges.get(index);
                        JOptionPane.showMessageDialog(null, charge.toStringFancy(), charge.getType().getName(), JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        pgPaymentHistoryList.setSelectionBackground(new Color(252, 189, 27));
        pgPaymentHistoryScroll.setViewportView(pgPaymentHistoryList);
    }
}