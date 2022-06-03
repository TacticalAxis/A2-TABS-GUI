package a2.tabs.gui;

import a2.tabs.gui.database.DBConnection;
import a2.tabs.gui.view.admin.AdminDashboard;
import a2.tabs.gui.view.main.TabStartup;
import a2.tabs.gui.view.user.Dashboard;

public class Tabs {

    public static DBConnection db;
    public static TabStartup tabStartup;
    public static Dashboard dashboard;
    public static AdminDashboard adminDashboard;
    public static boolean isAdmin;

    public static void main(String[] args) {
        db = new DBConnection();
        tabStartup = new TabStartup();
        tabStartup.setVisible(true);
        isAdmin = false;
    }
}