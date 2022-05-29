package a2.tabs.gui.database;

import a2.tabs.gui.controller.Config;
import a2.tabs.gui.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
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
        StringBuilder sb = new StringBuilder("CREATE TABLE \"" + tableName + "\" (");
        sb.append(columnList);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");

        String sql = sb.toString();
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

        dbConnection.createTable(User.tableName, User.model());

        System.out.println(dbConnection.getTables());

        User user = new User.UserBuilder(
                    "somusername",
                    "name",
                    "email",
                    "nathan",
                    "rheem")
                    .setAddress("asghdjasgdjh")
                    .setPhone("123456789").setCarRego("123456").setSalary(123.45).setDateOfBirth(LocalDate.of(2002, Month.JANUARY, 23)).build();


        User user2 = new User.UserBuilder(
                "somusername",
                "name",
                "email",
                "nathan",
                "rheem")
                .setAddress("asghdjasgdjh")
                .setPhone("123456789").setCarRego("123456").setSalary(123.45).build();

        dbConnection.push(user);
        dbConnection.push(user2);

        dbConnection.close();
    }
}