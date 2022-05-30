package a2.tabs.gui.model;

import a2.tabs.gui.controller.Config;
import a2.tabs.gui.database.*;

import java.time.LocalDate;

public class Charge implements Databaseable<String> {

    public static final String TABLE_NAME = Config.DB_TABLE_CHARGE;

    private final ChargeType type;
    private final User user;
    private final LocalDate date;

    public Charge(ChargeType type, User user, LocalDate date) {
        this.type = type;
        this.user = user;
        this.date = date;
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

    @Override
    public boolean create(DBConnection db) {
        return false;
    }

    @Override
    public boolean delete(DBConnection db) {
        return false;
    }

    @Override
    public void push(DBConnection db) {
        // to be implemented later
    }

    @Override
    public boolean keyExists(DBConnection db, String key) {
        return false;
    }

    @Override
    public void pull(DBConnection db) {
        // to be implemented later
    }

    public static ColumnList model() {
        return new ColumnList(
                new Column[]{
                        new Column("id", ColumnType.INTEGER, 0, false, true, true),
                        new Column("name", ColumnType.STRING, 500, false, false, false)
                }
        );
    }
}
