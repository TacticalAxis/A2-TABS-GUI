package a2.tabs.gui.database;

public interface Databaseable<E> {
    boolean create(DBConnection db);

    boolean delete(DBConnection db);

    boolean push(DBConnection db);

    boolean keyExists(DBConnection db, E key);

    boolean pull(DBConnection db);
}