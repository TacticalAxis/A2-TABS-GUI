package a2.tabs.gui.model;

import a2.tabs.gui.controller.Config;
import a2.tabs.gui.database.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MessageAdmin implements Databaseable<MessageAdmin> {

    public static final String TABLE_NAME = Config.DB_TABLE_MESSAGE_ADMIN;

    private final User user;
    private final String message;
    private final long timestamp;

    public MessageAdmin(User user, String message, long timestamp) {
        this.user = user;
        this.message = message;
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean create(DBConnection db) {
        try(Statement stmt = db.getConnection().createStatement()) {
            String sql = String.format("INSERT INTO \"%s\" (userID, message, timestamp) VALUES ('%s', '%s', %d)", TABLE_NAME, user.getUsername(), message, timestamp);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean delete(DBConnection db) {
        try(Statement stmt = db.getConnection().createStatement()) {
            String sql = String.format("DELETE FROM \"%s\" WHERE userID = '%s' AND message = '%s' AND timestamp = %d", TABLE_NAME, user.getUsername(), message, timestamp);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public void push(DBConnection db) {
        boolean exists = false;
        for (MessageAdmin m : get(db)) {
            if (m.equals(this)) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            create(db);
        }
    }

    @Override
    public boolean keyExists(DBConnection db, MessageAdmin key) {
        return get(db).contains(key);
    }

    @Override
    public void pull(DBConnection db) {
        throw new UnsupportedOperationException("Unsupported operation, messages are read-only");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageAdmin message1 = (MessageAdmin) o;
        return timestamp == message1.timestamp && Objects.equals(user, message1.user) && Objects.equals(message, message1.message);
    }

    public static ColumnList model() {
        return new ColumnList(
            new Column[]{
                new Column("userID", ColumnType.STRING, 50, false),
                new Column("message", ColumnType.STRING, 255, false),
                new Column("timestamp", ColumnType.LONG, 0, false)
            }
        );
    }

    public static List<MessageAdmin> get(DBConnection db) {
        List<MessageAdmin> messages = new ArrayList<>();

        try (Statement stmt = db.getConnection().createStatement()) {
            String sql = String.format("SELECT * FROM \"%s\"", TABLE_NAME);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = User.get(db, rs.getString("userID"));
                String message = rs.getString("message");
                long timestamp = rs.getLong("timestamp");
                messages.add(new MessageAdmin(user, message, timestamp));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messages;
    }

    public static List<MessageAdmin> get(DBConnection db, User user) {
        List<MessageAdmin> messages = new ArrayList<>();

        try (Statement stmt = db.getConnection().createStatement()) {
            String sql = String.format("SELECT * FROM \"%s\" WHERE userID = '%s'", TABLE_NAME, user.getUsername());
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String message = rs.getString("message");
                long timestamp = rs.getLong("timestamp");
                messages.add(new MessageAdmin(user, message, timestamp));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messages;
    }

    @Override
    public String toString() {
        return "Message{" +
                "user=" + user.getUsername() +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}