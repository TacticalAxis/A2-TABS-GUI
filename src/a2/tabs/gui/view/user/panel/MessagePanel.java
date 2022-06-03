package a2.tabs.gui.view.user.panel;

import a2.tabs.gui.Tabs;
import a2.tabs.gui.model.MessageAdmin;
import a2.tabs.gui.model.MessageUser;
import a2.tabs.gui.model.User;
import a2.tabs.gui.model.util.Message;
import a2.tabs.gui.util.TimeConstants;
import a2.tabs.gui.util.MessageStringifier;
import a2.tabs.gui.view.user.Dashboard;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MessagePanel extends JPanel {

    private final User user;
    private final Dashboard dashboard;

    private JList<String> pgMessagesMessageHistoryList;
    private JTextField pgMessagesSendMessagesTextField;

    public MessagePanel(User user, Dashboard dashboard) {
        this.user = user;
        this.dashboard = dashboard;
        initComponents();
    }

    public void initComponents() {
        JLabel pgMessagesTitle = new JLabel();
        JLabel pgMessagesSendMessageHeading = new JLabel();
        pgMessagesSendMessagesTextField = new JTextField();
        JButton pgMessagesSendButton = new JButton();
        JLabel pgMessagesMessageHistoryHeading = new JLabel();
        JScrollPane pgMessagesMessageHistoryScroll = new JScrollPane();
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
        pgMessagesSendMessagesTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pgMessagesMessageHistoryList.clearSelection();
            }
        });

        pgMessagesSendButton.setBackground(new Color(0, 100, 172));
        pgMessagesSendButton.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        pgMessagesSendButton.setForeground(new Color(204, 204, 204));
        pgMessagesSendButton.setIcon(new ImageIcon("resources/image/MessagesPane-SendButton.png"));
        pgMessagesSendButton.setBorder(null);
        pgMessagesSendButton.setBorderPainted(false);
        pgMessagesSendButton.setContentAreaFilled(false);
        pgMessagesSendButton.addActionListener(evt -> {
            String message = pgMessagesSendMessagesTextField.getText();
            if (message.length() <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter a message to send", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            MessageAdmin msg = new MessageAdmin(user, message, System.currentTimeMillis());
            msg.push(Tabs.db);
            pgMessagesSendMessagesTextField.setText("");
            dashboard.refreshCurrentPanel();

            JOptionPane.showMessageDialog(null, "Message sent", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        pgMessagesMessageHistoryHeading.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgMessagesMessageHistoryHeading.setForeground(new Color(153, 153, 153));
        pgMessagesMessageHistoryHeading.setText("Message History");

        pgMessagesMessageHistoryList.setBackground(new Color(204, 204, 204));
        pgMessagesMessageHistoryList.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgMessagesMessageHistoryList.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgMessagesMessageHistoryList.setForeground(new Color(102, 102, 102));

        java.util.List<MessageUser> messagesFromAdmin = MessageUser.get(Tabs.db, user);
        java.util.List<MessageAdmin> messagesToAdmin = MessageAdmin.get(Tabs.db, user);
        java.util.List<Message> messages = new ArrayList<>();
        messages.addAll(messagesFromAdmin);
        messages.addAll(messagesToAdmin);

        // sort all messages by time
        messages.sort((o1, o2) -> Long.compare(o2.getTimestamp(), o1.getTimestamp()));

        final String[] messageStrings = new String[messages.size()];
        for (int i = 0; i < messages.size(); i++) {
            StringBuilder sb = new StringBuilder("[");

            // append the datetime
            String dateTime = TimeConstants.timeMillisToDateTimeString(messages.get(i).getTimestamp());
            sb.append(dateTime);

            // append the sender
            if (messages.get(i) instanceof MessageAdmin) {
                sb.append("] To Admin");
                sb.append(": ");
            } else {
                sb.append("] From Admin: ");
            }

            // append the message
            sb.append(MessageStringifier.shorten(messages.get(i).getMessage(), 15));
            messageStrings[i] = sb.toString();
        }

        pgMessagesMessageHistoryList.setModel(new AbstractListModel<String>() {
            final String[] strings = messageStrings;
            public int getSize() {
                return strings.length;
            }
            public String getElementAt(int i) {
                return strings[i];
            }
        });

        pgMessagesMessageHistoryList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int index = pgMessagesMessageHistoryList.locationToIndex(evt.getPoint());
                    if (index >= 0) {
                        JOptionPane.showMessageDialog(null, messages.get(index).getMessage(), "View Message sent @ " +TimeConstants.timeMillisToDateTimeString(messages.get(index).getTimestamp()), JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
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