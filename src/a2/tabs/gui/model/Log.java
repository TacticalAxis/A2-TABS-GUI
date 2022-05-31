package a2.tabs.gui.model;

import a2.tabs.gui.controller.Config;
import a2.tabs.gui.database.*;
import a2.tabs.gui.util.misc.TimeConstants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Log implements Databaseable<Log> {

    public static final String TABLE_NAME = Config.DB_TABLE_LOG;

    private final long timestamp;
    private final String message;

    public Log(long timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }


    @Override
    public boolean create(DBConnection db) {
        if (keyExists(db, this)) {
            return false;
        }

        try(Statement stmt = db.getConnection().createStatement()) {
            String query = "INSERT INTO \"" + TABLE_NAME + "\" (timestamp, message) VALUES (" + timestamp + ", '" + message + "')";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean delete(DBConnection db) {
        throw new UnsupportedOperationException("Cannot delete a log");
    }

    @Override
    public void push(DBConnection db) {
        boolean exists = false;
        for (Log c : get(db)) {
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
    public boolean keyExists(DBConnection db, Log key) {
        return get(db).contains(key);
    }

    @Override
    public void pull(DBConnection db) {
        throw new UnsupportedOperationException("Logs are read-only");
    }

    public static List<Log> get(DBConnection db) {
        List<Log> logs = new ArrayList<>();

        try(Statement stmt = db.getConnection().createStatement()) {
            String query = "SELECT * FROM \"" + TABLE_NAME + "\"";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                long timestamp = rs.getLong("timestamp");
                String message = rs.getString("message");

                logs.add(new Log(timestamp, message));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return logs;
    }

    public static ColumnList model() {
        return new ColumnList(
            new Column[]{
                new Column("id", ColumnType.INTEGER, 0, false, true, true),
                new Column("timestamp", ColumnType.LONG, 0, false, false, false),
                new Column("message", ColumnType.STRING, 255, false, false, false)
            }
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return timestamp == log.timestamp && Objects.equals(message, log.message);
    }

    @Override
    public String toString() {
        return "Log{" +
                "timestamp=" + TimeConstants.timeMillisToDateString(timestamp) +
                ", message='" + message + '\'' +
                '}';
    }
}
