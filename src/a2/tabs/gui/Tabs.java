package a2.tabs.gui;

import a2.tabs.gui.database.DBConnection;
import a2.tabs.gui.model.User;
import a2.tabs.gui.view.Dashboard;

import javax.swing.*;
import java.awt.*;

public class Tabs extends JFrame {

    private static DBConnection db;
    private static User user;
    private static Tabs instance;

    public Tabs() {
        db = new DBConnection();
        instance = this;
    }

    public static Tabs getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        User user = User.get(db, "nathand123");
        System.out.println(user.getUsername());
        EventQueue.invokeLater(() -> new Dashboard(user).setVisible(true));
    }
}