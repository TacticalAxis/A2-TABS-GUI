package a2.tabs.gui.database;

import a2.tabs.gui.controller.Config;
import a2.tabs.gui.model.Charge;
import a2.tabs.gui.model.MessageAdmin;
import a2.tabs.gui.model.MessageUser;
import a2.tabs.gui.model.User;
import a2.tabs.gui.model.util.ChargeType;
import a2.tabs.gui.util.TimeConstants;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    Connection connection = null;
    String url = Config.DB_URL;
    String urlTest = Config.DB_TEST_URL;
    String dbUser = Config.DB_USER;
    String dbPassword = Config.DB_PASS;
    
    public static boolean testing = false;

    public DBConnection() {
        init(false);
    }

    public DBConnection(boolean insertTestData) {
        init(insertTestData);
    }

    private void init(boolean insertTestData) {
        try {
            // setup connection
            if (!testing) {
                connection = DriverManager.getConnection(url, dbUser, dbPassword);
            } else {
                connection = DriverManager.getConnection(urlTest, dbUser, dbPassword);
            }
            System.out.println("Connected to database");

            // create tables
            List<String> tables = getTables();
            boolean tablesExist = tables.contains(User.TABLE_NAME) && tables.contains(Charge.TABLE_NAME) && tables.contains(MessageUser.TABLE_NAME) && tables.contains(MessageAdmin.TABLE_NAME);
            if (!tablesExist) {
                dropAllTables();
                createTable(Charge.TABLE_NAME, Charge.model());
                createTable(User.TABLE_NAME, User.model());
                createTable(MessageUser.TABLE_NAME, MessageUser.model());
                createTable(MessageAdmin.TABLE_NAME, MessageAdmin.model());

                // insert test data
                if (insertTestData) {
                    insertPreRunData();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    // close connection
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // create table based on column list
    public void createTable(String tableName, ColumnList columnList) {
        String sql = "CREATE TABLE \"" + tableName + "\" (" + columnList + ")";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // drop tables
    public void dropAll(List<String> tables) {
        for (String table : tables) {
            dropTable(table);
        }
    }

    // drop table
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

    private void insertPreRunData() {
        User user = new User(
                "nathand123",
                "password",
                "someemail@gmail.com",
                "Nathan",
                "Dsouza",
                LocalDate.of(2002, 1, 23),
                false
        );
        user.setCarRego("ABC123");
        user.setSalary(100000);
        user.setIrdNumber("123-123-123");
        user.setAddress("123 Fake Street");

        User user2 = new User(
                "babnato64",
                "password2",
                "doe2222",
                "Bab",
                "Nato",
                LocalDate.of(2002, 12, 14),
                false
        );

        user2.setCarRego("DEF456");
        user2.setSalary(100000);
        user2.setIrdNumber("123-456-789");
        user2.setAddress("124 Fake Street");

        push(user, user2);

        Charge charge = new Charge(ChargeType.INTERNET_BILL, user, LocalDate.of(2020, 5, 5), false);
        Charge charge2 = new Charge(ChargeType.WATER_BILL, user, LocalDate.of(2021, 2, 3), true);
        Charge charge3 = new Charge(ChargeType.ROAD_USER_CHARGES, user, LocalDate.of(2021, 2, 3), false);
        Charge charge4 = new Charge(ChargeType.SPEEDING_VIOLATION, user2, LocalDate.of(2022, 12, 5), true);
        Charge charge5 = new Charge(ChargeType.ELECTRICITY_BILL, user2, LocalDate.of(2022, 12, 5), false);

        push(charge, charge2, charge3, charge4, charge5);

        MessageAdmin mu1 = new MessageAdmin(user, "Hey there, I was having some issues with my billing!", System.currentTimeMillis() - (TimeConstants.DAY.getMillis() * 10));
        MessageUser ma1 = new MessageUser(user, "That's interesting, I'll check it out right away!", System.currentTimeMillis() - (TimeConstants.DAY.getMillis() * 9));
        MessageAdmin mu2 = new MessageAdmin(user, "Thanks a lot, let me know when you got it!", System.currentTimeMillis() - (TimeConstants.DAY.getMillis() * 8));
        MessageUser ma2 = new MessageUser(user, "I'll get back to you as soon as possible!", System.currentTimeMillis() - (TimeConstants.DAY.getMillis() * 7));

        MessageAdmin mu3 = new MessageAdmin(user2, "Hey there, please resolve some issues I've been having!", System.currentTimeMillis() - (TimeConstants.DAY.getMillis() * 6));
        MessageUser ma3 = new MessageUser(user2, "I'll get back to you as soon as possible!", System.currentTimeMillis() - (TimeConstants.DAY.getMillis() * 5));
        MessageAdmin mu4 = new MessageAdmin(user2, "Ok, great!", System.currentTimeMillis() - (TimeConstants.DAY.getMillis() * 4));
        MessageUser ma4 = new MessageUser(user2, "Have a good day!", System.currentTimeMillis() - (TimeConstants.DAY.getMillis() * 3));

        push(mu1, ma1, mu2, ma2, mu3, ma3, mu4, ma4);
    }

    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        dbConnection.close();
    }
}