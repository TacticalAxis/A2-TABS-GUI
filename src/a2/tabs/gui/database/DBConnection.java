package a2.tabs.gui.database;

import a2.tabs.gui.controller.Config;
import a2.tabs.gui.model.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    Connection connection = null;
    String url = Config.DB_URL;
    String dbUser = Config.DB_USER;
    String dbPassword = Config.DB_PASS;

    public DBConnection() {
        init();
    }

    private void init() {
        try {
            connection = DriverManager.getConnection(url, dbUser, dbPassword);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName, ColumnList columnList) {
        String sql = "CREATE TABLE \"" + tableName + "\" (" + columnList + ")";
        System.out.println(sql);

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropAll(List<String> tables) {
        for (String table : tables) {
            dropTable(table);
        }
    }

    public void dropTable(String tableName) {
        String sql = "DROP TABLE \"" + tableName + "\"";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropAllTables() {
        dropAll(getTables());
    }

    public List<String> getTables() {
        List<String> tables = new ArrayList<>();

        try {
            // setup db-metadata object and types
            DatabaseMetaData meta = this.connection.getMetaData();
            String[] types = {"TABLE"};

            // get table names
            ResultSet rs = meta.getTables(null, null, null, types);

            // check if table exists
            while(rs.next()) {
                String name = rs.getString("TABLE_NAME");
                tables.add(name);
            }

            rs.close();
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return tables;
    }

    public void push(Databaseable<?>... model) {
        for (Databaseable<?> m : model) {
            m.push(this);
        }
    }

    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();

        dbConnection.dropAllTables();

        dbConnection.createTable(Charge.TABLE_NAME, Charge.model());
        dbConnection.createTable(User.TABLE_NAME, User.model());
        dbConnection.createTable(MessageUser.TABLE_NAME, MessageUser.model());
        dbConnection.createTable(MessageAdmin.TABLE_NAME, MessageAdmin.model());
        dbConnection.createTable(Log.TABLE_NAME, Log.model());

        User user = new User(
                "nathand123",
                "nathan",
                "doe",
                "Nathan",
                "Dsouza",
                LocalDate.of(2002, 1, 23),
                "02102362281"
        );

        User user2 = new User(
                "blakef26",
                "bf234",
                "doe2222",
                "Blake",
                "Fernandes",
                LocalDate.of(2002, 12, 14),
                "02102362281"
        );

        dbConnection.push(user, user2);

        Charge charge = new Charge(ChargeType.INTERNET_BILL, user, LocalDate.of(2020, 5, 5), false);
        Charge charge2 = new Charge(ChargeType.WATER_BILL, user2, LocalDate.of(2021, 2, 3), true);
        Charge charge3 = new Charge(ChargeType.ROAD_USER_CHARGES, user2, LocalDate.of(2021, 2, 3), false);
        Charge charge4 = new Charge(ChargeType.SPEEDING_VIOLATION, user2, LocalDate.of(2022, 12, 5), true);
        Charge charge5 = new Charge(ChargeType.ELECTRICITY_BILL, user, LocalDate.of(2020, 12, 5), false);

        dbConnection.push(charge, charge2, charge3, charge4, charge5);

        System.out.println("Printing data for user: " + user.getUsername());
        System.out.println(Charge.get(dbConnection, user));

        System.out.println("Printing data for user2: " + user2.getUsername());
        System.out.println(Charge.get(dbConnection, user2));

        MessageUser messageUser = new MessageUser(user, "Hello World!", System.currentTimeMillis());
        MessageUser messageUser2 = new MessageUser(user2, "I hope youre!", System.currentTimeMillis());
        MessageUser messageUser3 = new MessageUser(user, "Having!", System.currentTimeMillis());
        MessageUser messageUser4 = new MessageUser(user2, "a great!", System.currentTimeMillis());
        MessageUser messageUser5 = new MessageUser(user, "day!", System.currentTimeMillis());

        dbConnection.push(messageUser, messageUser2, messageUser3, messageUser4, messageUser5);

        System.out.println("Messages for user: " + user.getUsername());
        System.out.println(MessageUser.get(dbConnection, user));

        System.out.println("Messages for user2: " + user2.getUsername());
        System.out.println(MessageUser.get(dbConnection, user2));

        MessageAdmin messageAdmin = new MessageAdmin(user, "This is!", System.currentTimeMillis());
        MessageAdmin messageAdmin2 = new MessageAdmin(user2, "A great test!", System.currentTimeMillis());
        MessageAdmin messageAdmin3 = new MessageAdmin(user, "To see!", System.currentTimeMillis());
        MessageAdmin messageAdmin4 = new MessageAdmin(user2, "whether these work!", System.currentTimeMillis());
        MessageAdmin messageAdmin5 = new MessageAdmin(user, "or not!", System.currentTimeMillis());

        dbConnection.push(messageAdmin, messageAdmin2, messageAdmin3, messageAdmin4, messageAdmin5);

        System.out.println("Messages for admin: " + user.getUsername());
        System.out.println(MessageAdmin.get(dbConnection, user));

        System.out.println("Messages for admin2: " + user2.getUsername());
        System.out.println(MessageAdmin.get(dbConnection, user2));

        Log log = new Log(System.currentTimeMillis(), "This is a test log!");
        Log log2 = new Log(System.currentTimeMillis(), "This is another test log!");
        Log log3 = new Log(System.currentTimeMillis(), "This is a third test log!");
        Log log4 = new Log(System.currentTimeMillis(), "This is a fourth test log!");
        Log log5 = new Log(System.currentTimeMillis(), "This is a fifth test log!");

        dbConnection.push(log, log2, log3, log4, log5);

        System.out.println("Logs: ");
        System.out.println(Log.get(dbConnection));

        dbConnection.close();
    }
}