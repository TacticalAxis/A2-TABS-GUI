package a2.tabs.gui.view.panel;

import a2.tabs.gui.model.User;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

@SuppressWarnings("FieldCanBeLocal")
public class PaymentPanel extends JPanel {

    private User user;

    private JLabel pgPaymentHistoryLabel;
    private JList<String> pgPaymentHistoryList;
    private JScrollPane pgPaymentHistoryScroll;
    private JLabel pgPaymentTitle;
    private JLabel pgPaymentUpcomingLabel;
    private JList<String> pgPaymentUpcomingList;
    private JScrollPane pgPaymentUpcomingScroll;

    public PaymentPanel(User user) {
        this.user = user;
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

        pgPaymentTitle.setFont(new Font("Bahnschrift", Font.BOLD, 36)); // NOI18N
        pgPaymentTitle.setForeground(new Color(0, 100, 172));
        pgPaymentTitle.setText("Payments");

        pgPaymentUpcomingLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgPaymentUpcomingLabel.setForeground(new Color(153, 153, 153));
        pgPaymentUpcomingLabel.setText("Upcoming Payments");

        pgPaymentUpcomingList.setBackground(new Color(204, 204, 204));
        pgPaymentUpcomingList.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgPaymentUpcomingList.setFont(new Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        pgPaymentUpcomingList.setForeground(new Color(102, 102, 102));
        pgPaymentUpcomingList.setModel(new AbstractListModel<String>() {
            final String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        pgPaymentUpcomingList.setSelectionBackground(new Color(252, 189, 27));
        pgPaymentUpcomingScroll.setViewportView(pgPaymentUpcomingList);

        pgPaymentHistoryLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgPaymentHistoryLabel.setForeground(new Color(153, 153, 153));
        pgPaymentHistoryLabel.setText("Payment History");

        pgPaymentHistoryList.setBackground(new Color(204, 204, 204));
        pgPaymentHistoryList.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgPaymentHistoryList.setFont(new Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        pgPaymentHistoryList.setForeground(new Color(102, 102, 102));
        pgPaymentHistoryList.setModel(new AbstractListModel<String>() {
            final String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        pgPaymentHistoryList.setSelectionBackground(new Color(252, 189, 27));
        pgPaymentHistoryScroll.setViewportView(pgPaymentHistoryList);

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

}
