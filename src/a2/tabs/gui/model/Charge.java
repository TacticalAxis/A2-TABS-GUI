package a2.tabs.gui.model;

import a2.tabs.gui.controller.Config;
import a2.tabs.gui.database.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Charge implements Databaseable<Integer> {

    public static final String TABLE_NAME = Config.DB_TABLE_CHARGE;

    private int id;
    private final ChargeType type;
    private final User user;
    private final LocalDate date;
    private boolean paid;

    public Charge(ChargeType type, User user, LocalDate date, boolean paid) {
        this.id = -1;
        this.type = type;
        this.user = user;
        this.date = date;
        this.paid = paid;
    }

    public Charge(int id, ChargeType type, User user, LocalDate date, boolean paid) {
        this.id = id;
        this.type = type;
        this.user = user;
        this.date = date;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public ChargeType getType() {
        return type;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public boolean create(DBConnection db) {
        try(Statement stmt = db.getConnection().createStatement()) {
            String query = String.format("INSERT INTO \"%s\" (typeID, userID, dueDate, paid) VALUES (%d, '%s', '%s', %b)", TABLE_NAME, type.getId(), user.getUsername(), date, paid);
            this.id = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean delete(DBConnection db) {
        throw new UnsupportedOperationException("Unsupported operation, charges are read-only");
    }

    @Override
    public void push(DBConnection db) {
        if (id == -1) {
            create(db);
            return;
        }

        try(Statement stmt = db.getConnection().createStatement()) {
            String query = String.format("UPDATE \"%s\" SET typeID = %d, userID = '%s', dueDate = '%s', paid = %b WHERE id = %d", TABLE_NAME, type.getId(), user.getUsername(), date, paid, getId());
            System.out.println(query);
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean keyExists(DBConnection db, Integer key) {
        throw new UnsupportedOperationException("Unsupported operation, charges are read-only");
    }

    @Override
    public void pull(DBConnection db) {
        throw new UnsupportedOperationException("Unsupported operation, charges are read-only");
    }

    public static ColumnList model() {
        return new ColumnList(
            new Column[]{
                new Column("id", ColumnType.INTEGER, 0, false, true, true),
                new Column("typeID", ColumnType.INTEGER, 0, false, false, false),
                new Column("userID", ColumnType.STRING, 50, false, false, false),
                new Column("dueDate", ColumnType.DATE, 0, false, false, false),
                new Column("paid", ColumnType.BOOLEAN, 0, false, false, false)
            }
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Charge charge = (Charge) o;
        return paid == charge.paid && type == charge.type && Objects.equals(user, charge.user) && Objects.equals(date, charge.date);
    }

    public static List<Charge> get(DBConnection db) {
        List<Charge> charges = new ArrayList<>();

        try(Statement stmt = db.getConnection().createStatement()) {
            String query = "SELECT * FROM \"" + TABLE_NAME + "\"";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                ChargeType type = ChargeType.getById(rs.getInt("typeID"));
                User user = User.get(db, rs.getString("userID"));
                LocalDate date = rs.getDate("dueDate").toLocalDate();
                boolean paid = rs.getBoolean("paid");

                charges.add(new Charge(id, type, user, date, paid));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return charges;
    }

    public static List<Charge> get(DBConnection db, User user) {
        List<Charge> charges = new ArrayList<>();

        try(Statement stmt = db.getConnection().createStatement()) {
            String query = "SELECT * FROM \"" + TABLE_NAME + "\" WHERE userID = '" + user.getUsername() + "'";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                ChargeType type = ChargeType.getById(rs.getInt("typeID"));
                LocalDate date = rs.getDate("dueDate").toLocalDate();
                boolean paid = rs.getBoolean("paid");

                charges.add(new Charge(id, type, user, date, paid));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return charges;
    }

    public static List<Charge> get(DBConnection db, User user, boolean paid) {
        List<Charge> charges = new ArrayList<>();

        try(Statement stmt = db.getConnection().createStatement()) {
            String query = "SELECT * FROM \"" + TABLE_NAME + "\" WHERE userID = '" + user.getUsername() + "' AND paid = " + paid;
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                ChargeType type = ChargeType.getById(rs.getInt("typeID"));
                LocalDate date = rs.getDate("dueDate").toLocalDate();

                charges.add(new Charge(id, type, user, date, paid));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return charges;
    }

    @Override
    public String toString() {
        return "Charge{" +
                "type=" + type.getName() +
                ", user=" + user.getUsername() +
                ", date=" + date +
                ", paid=" + paid +
                '}';
    }

    public String toStringFancy() {
        return "Name: " + type.getName() +
                "\nDescription: " + type.getDescription() +
                "\nAmount: " + type.getAmount() +
                "\nRecurring: " + type.isRecurring() +
                "\nDate: " + date +
                "\nPaid: " + paid;
    }
}