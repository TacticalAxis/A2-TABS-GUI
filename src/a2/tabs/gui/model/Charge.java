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

public class Charge implements Databaseable<Charge> {

    public static final String TABLE_NAME = Config.DB_TABLE_CHARGE;

    private final ChargeType type;
    private final User user;
    private final LocalDate date;
    private final boolean paid;

    public Charge(ChargeType type, User user, LocalDate date, boolean paid) {
        this.type = type;
        this.user = user;
        this.date = date;
        this.paid = paid;
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

    @Override
    public boolean create(DBConnection db) {
        try(Statement stmt = db.getConnection().createStatement()) {
            String query = String.format("INSERT INTO \"%s\" (typeID, userID, dueDate, paid) VALUES (%d, '%s', '%s', %b)", TABLE_NAME, type.getId(), user.getUsername(), date, paid);
            stmt.executeUpdate(query);
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
        boolean exists = false;
        for (Charge c : get(db)) {
            if (c.equals(this)) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            create(db);
        }
    }

    @Override
    public boolean keyExists(DBConnection db, Charge key) {
        return get(db).contains(key);
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
                ChargeType type = ChargeType.getById(rs.getInt("typeID"));
                User user = User.get(db, rs.getString("userID"));
                LocalDate date = rs.getDate("dueDate").toLocalDate();
                boolean paid = rs.getBoolean("paid");

                charges.add(new Charge(type, user, date, paid));
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
                ChargeType type = ChargeType.getById(rs.getInt("typeID"));
                LocalDate date = rs.getDate("dueDate").toLocalDate();
                boolean paid = rs.getBoolean("paid");

                charges.add(new Charge(type, user, date, paid));
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
}