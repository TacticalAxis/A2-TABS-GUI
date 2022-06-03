package a2.tabs.gui.database;

public interface Databaseable<E> {
    boolean create(DBConnection db);

    boolean delete(DBConnection db);

    void push(DBConnection db);

    boolean keyExists(DBConnection db, E key);

    void pull(DBConnection db);

    @Override
    boolean equals(Object o);
}