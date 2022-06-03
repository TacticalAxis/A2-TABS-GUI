package a2.tabs.gui.view.main;

import a2.tabs.gui.view.main.panel.Startup;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings({"DuplicatedCode", "FieldCanBeLocal"})
public class TabStartup extends JFrame {

    public JPanel currentPanel;
    
    public TabStartup() {
        initComponents();
        this.setResizable(false);
        try {UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ignored) {}
    }

    private void initComponents() {
        currentPanel = new Startup(this);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("The Awesomest Billing System");
        setBackground(new Color(51, 51, 51));

        setDisplay(currentPanel);

        pack();
    }

    public void setDisplay(JPanel panel) {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    public static void main(String[] args) {
        try {UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ignored) {}
        EventQueue.invokeLater(() -> new TabStartup().setVisible(true));
    }
}