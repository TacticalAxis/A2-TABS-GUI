/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package a2.tabs.gui.view.admin.panel;

import a2.tabs.gui.controller.Tabs;
import a2.tabs.gui.model.MessageAdmin;
import a2.tabs.gui.model.MessageUser;
import a2.tabs.gui.model.User;
import a2.tabs.gui.model.util.Message;
import a2.tabs.gui.util.misc.TimeConstants;
import a2.tabs.gui.util.misc.UtilString;
import a2.tabs.gui.view.admin.AdminDashboard;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

@SuppressWarnings({"FieldCanBeLocal"})
public class AdminMessages extends JPanel {

    private final AdminDashboard adminDashboard;

    private JLabel pgMessagesMessageHistoryHeading;
    private JList<String> pgMessagesMessageHistoryList;
    private JScrollPane pgMessagesMessageHistoryScroll;
    private JButton pgMessagesSendButton;
    private JLabel pgMessagesSendMessageHeading;
    private JTextField pgMessagesSendMessagesTextField;
    private JLabel pgMessagesTitle;
    private JComboBox<String> userSelector;

    public AdminMessages(AdminDashboard adminDashboard) {
        this.adminDashboard = adminDashboard;
        initComponents();
        try {UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ignored) {}
    }

    private void initComponents() {
        pgMessagesTitle = new JLabel();
        pgMessagesSendMessageHeading = new JLabel();
        pgMessagesSendMessagesTextField = new JTextField();
        pgMessagesSendButton = new JButton();
        pgMessagesMessageHistoryHeading = new JLabel();
        pgMessagesMessageHistoryScroll = new JScrollPane();
        pgMessagesMessageHistoryList = new JList<>();
        userSelector = new JComboBox<>();

        setForeground(new Color(246, 247, 251));

        pgMessagesTitle.setFont(new Font("Bahnschrift", Font.BOLD, 36)); // NOI18N
        pgMessagesTitle.setForeground(new Color(0, 100, 172));
        pgMessagesTitle.setText("Messages");

        pgMessagesSendMessageHeading.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgMessagesSendMessageHeading.setForeground(new Color(153, 153, 153));
        pgMessagesSendMessageHeading.setText("Send Message");

        pgMessagesSendMessagesTextField.setBackground(new Color(204, 204, 204));
        pgMessagesSendMessagesTextField.setFont(new Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        pgMessagesSendMessagesTextField.setForeground(new Color(102, 102, 102));
        pgMessagesSendMessagesTextField.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgMessagesSendMessagesTextField.setCaretColor(new Color(102, 102, 102));
        pgMessagesSendMessagesTextField.setOpaque(true);
        pgMessagesSendMessagesTextField.setSelectionColor(new Color(252, 189, 27));

        pgMessagesSendButton.setBackground(new Color(0, 100, 172));
        pgMessagesSendButton.setFont(new Font("Bahnschrift", Font.BOLD, 18)); // NOI18N
        pgMessagesSendButton.setForeground(new Color(204, 204, 204));
        pgMessagesSendButton.setIcon(new ImageIcon("resources/image/MessagesPane-SendButton.png")); // NOI18N
        pgMessagesSendButton.setBorder(null);
        pgMessagesSendButton.setBorderPainted(false);
        pgMessagesSendButton.setContentAreaFilled(false);
        pgMessagesSendButton.addActionListener(evt -> {
            String message = pgMessagesSendMessagesTextField.getText();
            if (message.length() <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter a message to send", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String user = (String) userSelector.getSelectedItem();

            MessageUser msg = new MessageUser(User.get(Tabs.db, user), message, System.currentTimeMillis());
            msg.push(Tabs.db);
            pgMessagesSendMessagesTextField.setText("");
            adminDashboard.refreshCurrentPanel();

            JOptionPane.showMessageDialog(null, "Message sent", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        pgMessagesMessageHistoryHeading.setFont(new Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        pgMessagesMessageHistoryHeading.setForeground(new Color(153, 153, 153));
        pgMessagesMessageHistoryHeading.setText("Message History");

        pgMessagesMessageHistoryList.setBackground(new Color(204, 204, 204));
        pgMessagesMessageHistoryList.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgMessagesMessageHistoryList.setFont(new Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        pgMessagesMessageHistoryList.setForeground(new Color(102, 102, 102));

        java.util.List<MessageUser> messagesFromUsers = MessageUser.get(Tabs.db);
        java.util.List<MessageAdmin> messagesToUsers = MessageAdmin.get(Tabs.db);
        java.util.List<Message> messages = new ArrayList<>();
        messages.addAll(messagesFromUsers);
        messages.addAll(messagesToUsers);

        // sort all messages by time
        messages.sort((o1, o2) -> Long.compare(o2.getTimestamp(), o1.getTimestamp()));

        final String[] messageStrings = new String[messages.size()];
        for (int i = 0; i < messages.size(); i++) {
            StringBuilder sb = new StringBuilder("[");

            // append the datetime
            String dateTime = TimeConstants.timeMillisToDateTimeString(messages.get(i).getTimestamp());
            sb.append(dateTime);

            // append the sender
            if (messages.get(i) instanceof MessageUser) {
                sb.append("] To ");
                sb.append(messages.get(i).getUser().getUsername());
                sb.append(": ");
            } else {
                sb.append("] From ");
                sb.append(messages.get(i).getUser().getUsername());
                sb.append(": ");
            }

//            sb.append("] - " + ("sender: " + messages.get(i).getSender())).append(messagesToUsers.contains(messages.get(i)) ? "To " : "From ").append(messages.get(i).getSender()).append(": ");

            // append the message
            sb.append(UtilString.shorten(messages.get(i).getMessage(), 15));
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


        userSelector.setBackground(new Color(204, 204, 204));
        userSelector.setFont(new Font("Bahnschrift", Font.PLAIN, 18)); // NOI18N
        userSelector.setForeground(new Color(102, 102, 102));
        userSelector.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        userSelector.setOpaque(true);

        java.util.List<String> users = new ArrayList<>();
        for (User user : User.get(Tabs.db)) {users.add(user.getUsername());}
        String[] userNames = new String[users.size()];
        userSelector.setModel(new DefaultComboBoxModel<>(users.toArray(userNames)));

        GroupLayout pgMessagesPanelLayout = new GroupLayout(this);
        setLayout(pgMessagesPanelLayout);
        pgMessagesPanelLayout.setHorizontalGroup(
            pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pgMessagesPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(pgMessagesMessageHistoryHeading, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pgMessagesTitle, GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
                    .addComponent(pgMessagesMessageHistoryScroll)
                    .addGroup(pgMessagesPanelLayout.createSequentialGroup()
                        .addComponent(pgMessagesSendMessageHeading, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userSelector, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pgMessagesPanelLayout.createSequentialGroup()
                        .addComponent(pgMessagesSendMessagesTextField, GroupLayout.PREFERRED_SIZE, 716, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pgMessagesSendButton, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pgMessagesPanelLayout.setVerticalGroup(
            pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pgMessagesPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(pgMessagesTitle, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pgMessagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(pgMessagesSendMessageHeading, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(userSelector, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
