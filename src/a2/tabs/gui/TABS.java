package a2.tabs.gui;

import a2.tabs.gui.database.DBConnection;

import javax.swing.*;

public class TABS extends JFrame {

    private final DBConnection dbConnection;
    private static TABS instance;

    public TABS() {
        this.dbConnection = new DBConnection();
        instance = this;
    }

    public static TABS getInstance() {
        return instance;
    }

    public static DBConnection getDBC() {
        return instance.dbConnection;
    }

    public static void main(String[] args) {
        // initialize the GUI

        // after login


//        JFrame main = new Dashboard2();
//        main.setTitle("TABS");
//        main.setSize(1280, 720);
//        main.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        main.setLocationRelativeTo(null);
//
//        main.setVisible(true);
    }
}