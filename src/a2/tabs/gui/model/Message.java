package a2.tabs.gui.model;

import a2.tabs.gui.database.DBConnection;
import a2.tabs.gui.database.Databaseable;

public class Message implements Databaseable<Integer> {
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
    public boolean keyExists(DBConnection db, Integer key) {
        return false;
    }

    @Override
    public void pull(DBConnection db) {
        // to be implemented later
    }
}
