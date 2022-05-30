package a2.tabs.gui.database;

import a2.tabs.gui.controller.Config;
import a2.tabs.gui.model.Charge;
import a2.tabs.gui.model.User;

import java.sql.*;
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
//        sb.deleteCharAt(sb.length() - 1);
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

        dbConnection.createTable(Charge.TABLE_NAME, Charge.model());
        dbConnection.createTable(User.TABLE_NAME, User.model());

        System.out.println(dbConnection.getTables());

//        Charge charge = new Charge();

        dbConnection.close();

//
//
//        User user = new User(
//                "nathand123",
//                "nathan",
//                "doe",
//                "Nathan",
//                "Dsouza",
//                LocalDate.of(2002, 1, 23),
//                "02102362281"
//        );
//
//        User user2 = new User(
//                "blakef26",
//                "bf234",
//                "doe2222",
//                "Blake",
//                "Fernandes",
//                LocalDate.of(2002, 12, 14),
//                "02102362281"
//        );
//
//        dbConnection.push(user);
//        dbConnection.push(user2);
//
//        User test = User.get(dbConnection, "nathand123");
//        User test2 = User.get(dbConnection, "blakef26");
//
//        System.out.println(user);
//        System.out.println(test);
//        System.out.println(user2);
//        System.out.println(test2);
//
//        System.out.println(user.equals(test));
//        System.out.println(user2.equals(test2));
//
//        System.out.println(user.equals(user2));
//        if (test != null) {
//            System.out.println(test.equals(test2));
//        }

//        dbConnection.close();
    }
}