package a2.tabs.gui.view.panel;

import a2.tabs.gui.model.User;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

@SuppressWarnings("FieldCanBeLocal")
public class MessagePanel extends JPanel {

    private User user;

    private JLabel pgMessagesMessageHistoryHeading;
    private JList<String> pgMessagesMessageHistoryList;
    private JScrollPane pgMessagesMessageHistoryScroll;
    private JButton pgMessagesSendButton;
    private JLabel pgMessagesSendMessageHeading;
    private JTextField pgMessagesSendMessagesTextField;
    private JLabel pgMessagesTitle;

    public MessagePanel(User user) {
        this.user = user;
        initComponents();
    }

    public void initComponents() {
        pgMessagesTitle = new JLabel();
        pgMessagesSendMessageHeading = new JLabel();
        pgMessagesSendMessagesTextField = new JTextField();
        pgMessagesSendButton = new JButton();
        pgMessagesMessageHistoryHeading = new JLabel();
        pgMessagesMessageHistoryScroll = new JScrollPane();
        pgMessagesMessageHistoryList = new JList<>();

        setForeground(new Color(246, 247, 251));

        pgMessagesTitle.setFont(new Font("Bahnschrift", Font.BOLD, 36));
        pgMessagesTitle.setForeground(new Color(0, 100, 172));
        pgMessagesTitle.setText("Messages");

        pgMessagesSendMessageHeading.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgMessagesSendMessageHeading.setForeground(new Color(153, 153, 153));
        pgMessagesSendMessageHeading.setText("Send Message");

        pgMessagesSendMessagesTextField.setBackground(new Color(204, 204, 204));
        pgMessagesSendMessagesTextField.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgMessagesSendMessagesTextField.setForeground(new Color(102, 102, 102));
        pgMessagesSendMessagesTextField.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgMessagesSendMessagesTextField.setCaretColor(new Color(102, 102, 102));
        pgMessagesSendMessagesTextField.setOpaque(true);
        pgMessagesSendMessagesTextField.setSelectionColor(new Color(252, 189, 27));

        pgMessagesSendButton.setBackground(new Color(0, 100, 172));
        pgMessagesSendButton.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        pgMessagesSendButton.setForeground(new Color(204, 204, 204));
        pgMessagesSendButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\MessagesPane-SendButton.png"));
        pgMessagesSendButton.setBorder(null);
        pgMessagesSendButton.setBorderPainted(false);
        pgMessagesSendButton.setContentAreaFilled(false);
        pgMessagesSendButton.addActionListener(evt -> {
            System.out.println("Send Message!");
            System.out.println("Send!");
        });

        pgMessagesMessageHistoryHeading.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgMessagesMessageHistoryHeading.setForeground(new Color(153, 153, 153));
        pgMessagesMessageHistoryHeading.setText("Message History");

        pgMessagesMessageHistoryList.setBackground(new Color(204, 204, 204));
        pgMessagesMessageHistoryList.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgMessagesMessageHistoryList.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgMessagesMessageHistoryList.setForeground(new Color(102, 102, 102));
        pgMessagesMessageHistoryList.setModel(new AbstractListModel<String>() {
            final String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        pgMessagesMessageHistoryList.setSelectionBackground(new Color(252, 189, 27));
        pgMessagesMessageHistoryScroll.setViewportView(pgMessagesMessageHistoryList);

        GroupLayout pgMessagesPanelLayout = new GroupLayout(this);
        setLayout(pgMessagesPanelLayout);
        pgMessagesPanelLayout.setHorizontalGroup(
                pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgMessagesPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pgMessagesMessageHistoryHeading, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pgMessagesTitle, GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
                                        .addComponent(pgMessagesSendMessageHeading, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(pgMessagesMessageHistoryScroll, GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.LEADING, pgMessagesPanelLayout.createSequentialGroup()
                                                        .addComponent(pgMessagesSendMessagesTextField, GroupLayout.PREFERRED_SIZE, 716, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(pgMessagesSendButton, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pgMessagesPanelLayout.setVerticalGroup(
                pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgMessagesPanelLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(pgMessagesTitle, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pgMessagesSendMessageHeading, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pgMessagesSendButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pgMessagesSendMessagesTextField))
                                .addGap(18, 18, 18)
                                .addComponent(pgMessagesMessageHistoryHeading, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pgMessagesMessageHistoryScroll, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}
