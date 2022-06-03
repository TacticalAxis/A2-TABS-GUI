package a2.tabs.gui;

import a2.tabs.gui.database.DBConnection;
import a2.tabs.gui.view.admin.AdminDashboard;
import a2.tabs.gui.view.main.TabsStartup;
import a2.tabs.gui.view.user.Dashboard;

public class Tabs {

    public static DBConnection db;
    public static TabsStartup tabsStartup;
    public static Dashboard dashboard;
    public static AdminDashboard adminDashboard;
    public static boolean isAdmin;

    // Github Link: https://github.com/TacticalAxis/A2-TABS-GUI

    // start program
    // login details for user:

    // username: nathand123
    // password: password

    // login details for admin: supersecretadminpassword
    
    public static void main(String[] args) {
        db = new DBConnection(true);
        tabsStartup = new TabsStartup();
        tabsStartup.setVisible(true);
        isAdmin = false;
    }
}