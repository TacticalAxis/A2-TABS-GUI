package a2.tabs.gui.database;

import a2.tabs.gui.controller.Config;
import a2.tabs.gui.model.Charge;
import a2.tabs.gui.model.ChargeType;
import a2.tabs.gui.model.User;

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

//        System.out.println(dbConnection.getTables());

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
        System.out.println(Charge.getAll(dbConnection, user));

        System.out.println("Printing data for user2: " + user2.getUsername());
        System.out.println(Charge.getAll(dbConnection, user2));

        dbConnection.close();
    }
}