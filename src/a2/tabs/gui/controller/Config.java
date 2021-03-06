package a2.tabs.gui.controller;

public class Config {

    private Config() {}

    public static final String DB_URL = "jdbc:derby:db/tabs;create=true";
    public static final String DB_TEST_URL = "jdbc:derby:db/tabsjunit;create=true";
    public static final String DB_USER = "tabs";
    public static final String DB_PASS = "super_secret_db_password";

    public static final String DB_TABLE_USER = "User";
    public static final String DB_TABLE_CHARGE = "Charge";
    public static final String DB_TABLE_MESSAGE_USER = "MessageUser";
    public static final String DB_TABLE_MESSAGE_ADMIN = "MessageAdmin";
}