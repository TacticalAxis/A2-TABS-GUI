package a2.tabs.gui.model;


import a2.tabs.gui.controller.Config;
import a2.tabs.gui.database.*;
import a2.tabs.gui.database.exception.DBException;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class User implements Databaseable<String> {

    public static String tableName = Config.DB_TABLE_USER;

    private final String username;
    private String password;
    private String email;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    private String phone;
    private String address;

    private String irdNumber;
    private double salary;
    private boolean ownsHome;
    private String carRego;

    public User(UserBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;

        this.dateOfBirth = builder.dateOfBirth;
        this.phone = builder.phone;
        this.address = builder.address;

        this.irdNumber = builder.irdNumber;
        this.salary = builder.salary;

        this.ownsHome = builder.ownsHome;
        this.carRego = builder.carRego;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
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

    @Override
    public boolean create(DBConnection db) {
        if (keyExists(db, username)) {
            throw new DBException("User already exists");
        }

        try(Statement stmt = db.getConnection().createStatement()) {
            String query = "INSERT INTO \"" + tableName + "\" (username, password, email, first_name, last_name, date_of_birth, phone, address, ird_number, salary, owns_home, car_rego) VALUES ('" + username + "', '" + password + "', '" + email + "', '" + firstName + "', '" + lastName + "', '" + Date.valueOf(dateOfBirth) + "', '" + phone + "', '" + address + "', '" + irdNumber + "', " + salary + ", " + ownsHome + ", '" + carRego + "')";
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
            stmt.executeUpdate("DELETE FROM " + tableName + " WHERE username = '" + username + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean push(DBConnection db) {
        if (!keyExists(db, username)) {
            create(db);
        } else {
            try (Statement stmt = db.getConnection().createStatement()) {
                String query = "UPDATE \"" + tableName + "\" SET (password, email, first_name, last_name, date_of_birth, phone, address, ird_number, salary, owns_home, car_rego) = ('" + password + "', '" + email + "', '" + firstName + "', '" + lastName + "', '" + (Date.valueOf(dateOfBirth)) + "', '" + phone + "', '" + address + "', '" + irdNumber + "', " + salary + ", " + ownsHome + ", '" + carRego + "') WHERE username = '" + username + "'";
                stmt.executeUpdate(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    @Override
    public boolean keyExists(DBConnection db, String key) {
        System.out.println("Checking if key exists: " + key);
        try (Statement stmt = db.getConnection().createStatement()) {
            String query = "SELECT * FROM \"" + tableName + "\" WHERE username = '" + key + "'";
            System.out.println(query);
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
    public boolean pull(DBConnection db) {
        return false;
    }

    public static class UserBuilder {
        private final String username;
        private final String password;
        private final String email;

        private final String firstName;
        private final String lastName;
        private LocalDate dateOfBirth;

        private String phone;
        private String address;

        private String irdNumber;
        private double salary;
        private boolean ownsHome;
        private String carRego;

        public UserBuilder(String username, String password, String email, String firstName, String lastName) {
            this.username = username;
            this.password = password;
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder setIrdNumber(String irdNumber) {
            this.irdNumber = irdNumber;
            return this;
        }

        public UserBuilder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public UserBuilder setOwnsHome(boolean ownsHome) {
            this.ownsHome = ownsHome;
            return this;
        }

        public UserBuilder setCarRego(String carRego) {
            this.carRego = carRego;
            return this;
        }

        private boolean validate(User user) {
            if (user.username.isEmpty()) {
                return false;
            }
            if (user.password.isEmpty()) {
                return false;
            }
            if (user.email.isEmpty()) {
                return false;
            }
            if (user.firstName.isEmpty()) {
                return false;
            }
            return !user.lastName.isEmpty();
        }

        public User build() {
            User user = new User(this);
            return validate(user) ? user : null;
        }
    }

    public static ColumnList model() {
        return new ColumnList(
            new Column[]{
                    new Column("username", ColumnType.STRING, 50, false, true, false),
                    new Column("password", ColumnType.STRING, 255, false),

                    new Column("email", ColumnType.STRING, 255, false),
                    new Column("first_name", ColumnType.STRING, 255, false),
                    new Column("last_name", ColumnType.STRING, 255, false),

                    new Column("date_of_birth", ColumnType.DATE, 0, false),
                    new Column("phone", ColumnType.STRING, 255, false),
                    new Column("address", ColumnType.STRING, 255, true),

                    new Column("ird_number", ColumnType.STRING, 255, true),
                    new Column("salary", ColumnType.DOUBLE, 0, false),

                    new Column("owns_home", ColumnType.BOOLEAN, 0, false),
                    new Column("car_rego", ColumnType.STRING, 6, true)
            }
        );
    }

    @Override
    public String toString() {
        return "User{" +
                "tableName='" + tableName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", irdNumber='" + irdNumber + '\'' +
                ", salary=" + salary +
                ", ownsHome=" + ownsHome +
                ", carRego='" + carRego + '\'' +
                '}';
    }
}

//    @Override
//    public String toString() {
//        return "user:" + this.username + "\n" +
//                "hash:" + this.password + "\n" +
//                "email:" + this.email + "\n" +
//                "firstName:" + this.firstName + "\n" +
//                "lastName:" + this.lastName + "\n" +
//                "address:" + this.address + "\n" +
//                "phone:" + this.phone + "\n" +
//                "irdNumber:" + this.irdNumber + "\n" +
//                "salary:" + this.salary + "\n" +
//                "ownsHome:" + this.ownsHome + "\n" +
//                "carRego:" + this.carRego + "\n";
//    }
//
//    public String viewSafeString() {
//        return "Username: " + this.username + "\n" +
//                "Email Address: " + this.email + "\n" +
//                "First Name: " + this.firstName + "\n" +
//                "Last Name: " + this.lastName + "\n" +
//                "Home Address: " + this.address + "\n" +
//                "Mobile Phone: " + this.phone + "\n" +
//                "IRD Number: " + this.irdNumber + "\n" +
//                "Salary: $" + this.salary + "\n" +
//                "Home Owner: " + this.ownsHome + "\n" +
//                "Car Registration: " + this.carRego + "\n";
//    }
//
//    public static List<String> getUsernames() {
////        Debug.log("User: getUsernames()");
//        List<String> takenUsernames = new ArrayList<>();
//        for (User user : users) {
//            takenUsernames.add(user.getUsername().toLowerCase());
//        }
//        return takenUsernames;
//    }
//
//    public boolean passwordCorrect(String attempted) {
//        return this.password.equals(hash(attempted));
//    }
//
//    public static String hash(String password) {
////        Debug.log("User: hash()");
//        MessageDigest md5;
//        try {
//            md5 = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException e) {
//            System.err.println("No MD5 algorithm found");
//            return null;
//        }
//
//        md5.update(StandardCharsets.UTF_8.encode(password));
//
//        return String.format("%032x", new BigInteger(1, md5.digest()));
//    }

//    public static User getUser(String username) {
//        Debug.log("User: getUser()");
//        for (User user : users) {
//            if (user.getUsername().equals(username)) {
//                return user;
//            }
//        }
//        return null;
//    }
//
//    public static void logout() {
//        currentUser = null;
//    }
//
//    public void addCharge(Charge charge) {
//        this.charges.add(charge);
//    }
//
//    public List<Charge> getCharges() {
//        List<Charge> charges = new ArrayList<>();
//        for (Charge charge : Charge.chargeList) {
//            if (charge.getUser().equals(this)) {
//                charges.add(charge);
//            }
//        }
//        return charges;
//    }
//
//    public List<Charge> getPendingCharges() {
//        List<Charge> charges = new ArrayList<>();
//        for (Charge charge : Charge.chargeList) {
//            if (charge.getUser().equals(this) && !charge.getIsPaid()) {
//                charges.add(charge);
//            }
//        }
//        return charges;
//    }
//}