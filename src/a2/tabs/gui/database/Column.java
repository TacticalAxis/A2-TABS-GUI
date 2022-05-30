package a2.tabs.gui.database;

public class Column {

    private final String name;
    private final ColumnType type;
    private final int length;
    private final boolean nullable;
    private final boolean primaryKey;
    private final boolean autoIncrement;

    public Column(String name, ColumnType type, int length, boolean nullable, boolean primaryKey, boolean autoIncrement) {
        this.name = name;
        this.type = type;
        this.length = length;
        this.nullable = nullable;
        this.primaryKey = primaryKey;
        this.autoIncrement = autoIncrement;
    }

    public Column(String name, ColumnType type, int length, boolean nullable, boolean primaryKey) {
        this.name = name;
        this.type = type;
        this.length = length;
        this.nullable = nullable;
        this.primaryKey = primaryKey;
        this.autoIncrement = false;
    }

    public Column(String name, ColumnType type, int length, boolean nullable) {
        this.name = name;
        this.type = type;
        this.length = length;
        this.nullable = nullable;
        this.primaryKey = false;
        this.autoIncrement = false;
    }

    public String getName() {
        return name;
    }

    public ColumnType getType() {
        return type;
    }

    public int getLength() {
        return length;
    }

    public boolean isNullable() {
        return nullable;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    @Override
    public String toString() {
        return "" + name + " " + type + (length != 0 ? "(" + length + ")" : "") + " " + (nullable ? "" : "NOT NULL") + (primaryKey ? " PRIMARY KEY" : "") + (autoIncrement ? " GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1)" : "");
    }
}
