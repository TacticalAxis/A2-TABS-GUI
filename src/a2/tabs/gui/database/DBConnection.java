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

    public boolean push(Databaseable<?> model) {
        model.push(this);
        return true;
    }

    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();

        dbConnection.dropAllTables();

        dbConnection.createTable(Charge.TABLE_NAME, Charge.model());
        dbConnection.createTable(User.TABLE_NAME, User.model());

        System.out.println(dbConnection.getTables());

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

        user.push(dbConnection);
        user2.push(dbConnection);

        Charge charge = new Charge(ChargeType.INTERNET_BILL, user, LocalDate.of(2020, 1, 1), false);
        Charge charge2 = new Charge(ChargeType.INTERNET_BILL, user2, LocalDate.of(2020, 1, 1), false);

        charge.push(dbConnection);
        charge2.push(dbConnection);

        dbConnection.close();
    }
}