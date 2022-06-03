package a2.tabs.gui.model;

import a2.tabs.gui.controller.Config;
import a2.tabs.gui.database.*;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused", "SqlResolve"})
public class User extends DBModelBase implements Databaseable<String> {

    public static final String TABLE_NAME = Config.DB_TABLE_USER;

    private final String username;
    private String password;
    private String email;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    private String address;

    private String irdNumber;
    private double salary;
    private boolean ownsHome;
    private String carRego;

    public User(String username, String password, String email, String firstName, String lastName, LocalDate dateOfBirth) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;

        this.address = null;
        this.irdNumber = null;
        this.salary = 0;
        this.ownsHome = false;
        this.carRego = null;
    }

    public User(String username, String password, String email, String firstName, String lastName, LocalDate dateOfBirth, boolean passPreHashed) {
        this.username = username;
        if (passPreHashed) {
            this.password = password;
        } else {
            this.password = hash(password);
        }
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;

        this.address = null;
        this.irdNumber = null;
        this.salary = 0;
        this.ownsHome = false;
        this.carRego = null;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        String hashedPassword = hash(password);
        if (hashedPassword != null) {
            this.password = hashedPassword;
        } else {
            throw new IllegalArgumentException("Password cannot be null");
        }
    }

    public boolean checkPassword(String password) {
        String hashedPassword = hash(password);
        if (hashedPassword != null) {
            return this.password.equals(hashedPassword);
        } else {
            throw new IllegalArgumentException("Password cannot be null");
        }
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getIrdNumber() {
        return irdNumber;
    }
    public void setIrdNumber(String irdNumber) {
        this.irdNumber = irdNumber;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isOwnsHome() {
        return ownsHome;
    }
    public void setOwnsHome(boolean ownsHome) {
        this.ownsHome = ownsHome;
    }

    public String getCarRego() {
        return carRego;
    }
    public void setCarRego(String carRego) {
        this.carRego = carRego;
    }

    public static User get(DBConnection db, String username) {
        try (Statement stmt = db.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM \"" + TABLE_NAME + "\" WHERE username = '" + username + "'");
            if (rs.next()) {
                User user = new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getDate("dateOfBirth").toLocalDate()
                );

                if (rs.getString("address") != null && !rs.getString("address").equals("null")) {
                        user.setAddress(rs.getString("address"));
                }

                if (rs.getString("irdNumber") != null && !rs.getString("irdNumber").equals("null")) {
                    user.setIrdNumber(rs.getString("irdNumber"));
                }

                if (rs.getDouble("salary") != 0) {
                    user.setSalary(rs.getDouble("salary"));
                }

                if (rs.getBoolean("ownsHome")) {
                    user.setOwnsHome(rs.getBoolean("ownsHome"));
                }

                if (rs.getString("carRego") != null && !rs.getString("carRego").equals("null")) {
                    user.setCarRego(rs.getString("carRego"));
                }

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<User> get(DBConnection db) {
        List<User> users = new ArrayList<>();

        try (Statement stmt = db.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM \"" + TABLE_NAME + "\"");
            while (rs.next()) {
                User user = new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getDate("dateOfBirth").toLocalDate()
                );

                if (rs.getString("address") != null && !rs.getString("address").equals("null")) {
                    user.setAddress(rs.getString("address"));
                }

                if (rs.getString("irdNumber") != null && !rs.getString("irdNumber").equals("null")) {
                    user.setIrdNumber(rs.getString("irdNumber"));
                }

                if (rs.getDouble("salary") != 0) {
                    user.setSalary(rs.getDouble("salary"));
                }

                if (rs.getBoolean("ownsHome")) {
                    user.setOwnsHome(rs.getBoolean("ownsHome"));
                }

                if (rs.getString("carRego") != null && !rs.getString("carRego").equals("null")) {
                    user.setCarRego(rs.getString("carRego"));
                }

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public boolean create(DBConnection db) {
        if (keyExists(db, username)) {
            throw new IllegalArgumentException("User already exists");
        }

        try(Statement stmt = db.getConnection().createStatement()) {
            String query = String.format("INSERT INTO \"%s\" (username, password, email, firstName, lastName, dateOfBirth, address, irdNumber, salary, ownsHome, carRego) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %f, %b, '%s')", TABLE_NAME, username, password, email, firstName, lastName, dateOfBirth, address, irdNumber, salary, ownsHome, carRego);
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean delete(DBConnection db) {
        if (!keyExists(db, username)) {
            return false;
        }

        try(Statement stmt = db.getConnection().createStatement()) {
            stmt.executeUpdate("DELETE FROM \"" + TABLE_NAME + "\" WHERE username = '" + username + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public void push(DBConnection db) {
        if (!keyExists(db, username)) {
            create(db);
        } else {
            try (Statement stmt = db.getConnection().createStatement()) {
                String query = String.format("UPDATE \"%s\" SET password = '%s', email = '%s', firstName = '%s', lastName = '%s', dateOfBirth = '%s', address = '%s', irdNumber = '%s', salary = %s, ownsHome = %s, carRego = '%s' WHERE username = '%s'", TABLE_NAME, password, email, firstName, lastName, Date.valueOf(dateOfBirth), address, irdNumber, salary, ownsHome, carRego, username);
                System.out.println(query);
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean keyExists(DBConnection db, String key) {
        try (Statement stmt = db.getConnection().createStatement()) {
            String query = "SELECT * FROM \"" + TABLE_NAME + "\" WHERE username = '" + key + "'";
            ResultSet rs = stmt.executeQuery(query);

            int size = 0;

            while (rs.next()) {
                size++;
            }

            return size > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void pull(DBConnection db) {
        // Does not need to be implemented
    }

    public boolean userEquals(User user) {
        return user.getUsername().equals(username) && user.getPassword().equals(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;

        boolean usernameEquals = username.equals(user.username);
        boolean passwordEquals = password.equals(user.password);
        boolean emailEquals = email.equals(user.email);
        boolean firstNameEquals = firstName.equals(user.firstName);
        boolean lastNameEquals = lastName.equals(user.lastName);
        boolean dateOfBirthEquals = dateOfBirth.equals(user.dateOfBirth);

        boolean addressEquals = false;
        if (address != null && user.address != null) {
            addressEquals = address.equals(user.address);
        } else if (address == null && user.address == null) {
            addressEquals = true;
        }

        boolean irdNumberEquals = false;
        if (irdNumber != null && user.irdNumber != null) {
            irdNumberEquals = irdNumber.equals(user.irdNumber);
        } else if (irdNumber == null && user.irdNumber == null) {
            irdNumberEquals = true;
        }

        boolean salaryEquals = salary == user.salary;
        boolean ownsHomeEquals = ownsHome == user.ownsHome;

        boolean carRegoEquals = false;
        if (carRego != null && user.carRego != null) {
            carRegoEquals = carRego.equals(user.carRego);
        } else if (carRego == null && user.carRego == null) {
            carRegoEquals = true;
        }

        return usernameEquals && passwordEquals && emailEquals && firstNameEquals && lastNameEquals && dateOfBirthEquals && addressEquals && irdNumberEquals && salaryEquals && ownsHomeEquals && carRegoEquals;
    }

    public static String hash(String password) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.err.println("No MD5 algorithm found");
            return null;
        }

        md5.update(StandardCharsets.UTF_8.encode(password));

        return String.format("%032x", new BigInteger(1, md5.digest()));
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", irdNumber='" + irdNumber + '\'' +
                ", salary=" + salary +
                ", ownsHome=" + ownsHome +
                ", carRego='" + carRego + '\'' +
                '}';
    }

    public static ColumnList model() {
        return new ColumnList(
            new Column[]{
                    new Column("username", ColumnType.STRING, 50, false, true, false),
                    new Column("password", ColumnType.STRING, 255, false),

                    new Column("email", ColumnType.STRING, 255, false),
                    new Column("firstName", ColumnType.STRING, 255, false),
                    new Column("lastName", ColumnType.STRING, 255, false),

                    new Column("dateOfBirth", ColumnType.DATE, 0, false),
                    new Column("address", ColumnType.STRING, 255, true),

                    new Column("irdNumber", ColumnType.STRING, 255, true),
                    new Column("salary", ColumnType.DOUBLE, 0, false),

                    new Column("ownsHome", ColumnType.BOOLEAN, 0, false),
                    new Column("carRego", ColumnType.STRING, 6, true)
            }
        );
    }
}