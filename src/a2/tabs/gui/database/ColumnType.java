package a2.tabs.gui.database;

public enum ColumnType {
    INTEGER("INTEGER", false),
    DOUBLE("DOUBLE", false),
    LONG("BIGINT", false),
    STRING("VARCHAR", true),
    DATE("DATE", false),
    TIME("TIME", false),
    DATETIME("DATETIME", false),
    BOOLEAN("BOOLEAN", false);

    private String type;
    private boolean lengthPermitted;

    ColumnType(String type, boolean lengthPermitted) {
        this.type = type;
        this.lengthPermitted = lengthPermitted;
    }

    @Override
    public String toString() {
        return this.type;
    }

    public String getType() {
        return this.type;
    }

    public boolean isLengthPermitted() {
        return this.lengthPermitted;
    }
}