package a2.tabs.gui.view.panel;

import a2.tabs.gui.model.User;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("FieldCanBeLocal")
public class HomePanel extends JPanel {

    private User user;

    private JLabel pgDashboardBillsLabel;
    private JLabel pgDashboardDueLabel;
    private JLabel pgDashboardFinesLabel;
    private JLabel pgDashboardOverdueLabel;
    private JLabel pgDashboardPaidLabel;
    private JLabel pgDashboardPaymentGraphImage;
    private JLabel pgDashboardPaymentGraphLabel;
    private JLabel pgDashboardStatisticsLabel;
    private JLabel pgDashboardTitle;

    public HomePanel(User user) {
        this.user = user;
        initComponents();
    }

    private void initComponents() {
        pgDashboardTitle = new JLabel();
        pgDashboardPaymentGraphLabel = new JLabel();
        pgDashboardStatisticsLabel = new JLabel();
        pgDashboardPaymentGraphImage = new JLabel();
        pgDashboardDueLabel = new JLabel();
        pgDashboardPaidLabel = new JLabel();
        pgDashboardOverdueLabel = new JLabel();
        pgDashboardBillsLabel = new JLabel();
        pgDashboardFinesLabel = new JLabel();

        setForeground(new Color(246, 247, 251));

        pgDashboardTitle.setFont(new Font("Bahnschrift", Font.BOLD, 36)); // NOI18N
        pgDashboardTitle.setForeground(new Color(0, 100, 172));
        pgDashboardTitle.setText("Dashboard");

        pgDashboardPaymentGraphLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgDashboardPaymentGraphLabel.setForeground(new Color(153, 153, 153));
        pgDashboardPaymentGraphLabel.setText("Payment Graph");

        pgDashboardStatisticsLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgDashboardStatisticsLabel.setForeground(new Color(153, 153, 153));
        pgDashboardStatisticsLabel.setText("Statistics");

        pgDashboardPaymentGraphImage.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\Dashboard-Graph.png")); // NOI18N

        pgDashboardDueLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 24)); // NOI18N
        pgDashboardDueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pgDashboardDueLabel.setText("Payments Due: 25");

        pgDashboardPaidLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 24)); // NOI18N
        pgDashboardPaidLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pgDashboardPaidLabel.setText("Payments Paid: 25");

        pgDashboardOverdueLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 24)); // NOI18N
        pgDashboardOverdueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pgDashboardOverdueLabel.setText("Payments Overdue: 25");

        pgDashboardBillsLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 24)); // NOI18N
        pgDashboardBillsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pgDashboardBillsLabel.setText("Bills: 25");

        pgDashboardFinesLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 24)); // NOI18N
        pgDashboardFinesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pgDashboardFinesLabel.setText("Fines: 25");

        GroupLayout pgDashboardPanelLayout = new GroupLayout(this);
        setLayout(pgDashboardPanelLayout);
        pgDashboardPanelLayout.setHorizontalGroup(
                pgDashboardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, pgDashboardPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(pgDashboardPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(pgDashboardTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pgDashboardPanelLayout.createSequentialGroup()
                                                .addGroup(pgDashboardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(pgDashboardPaymentGraphLabel, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pgDashboardPaymentGraphImage, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(pgDashboardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(pgDashboardStatisticsLabel, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                                                        .addGroup(pgDashboardPanelLayout.createSequentialGroup()
                                                                .addGroup(pgDashboardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(pgDashboardDueLabel, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(pgDashboardPaidLabel, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(pgDashboardOverdueLabel, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(pgDashboardBillsLabel, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(pgDashboardFinesLabel, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addContainerGap())
        );
        pgDashboardPanelLayout.setVerticalGroup(
                pgDashboardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgDashboardPanelLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(pgDashboardTitle, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pgDashboardPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(pgDashboardPaymentGraphLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pgDashboardStatisticsLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pgDashboardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(pgDashboardPaymentGraphImage, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pgDashboardPanelLayout.createSequentialGroup()
                                                .addComponent(pgDashboardDueLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pgDashboardPaidLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pgDashboardOverdueLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pgDashboardBillsLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pgDashboardFinesLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}
