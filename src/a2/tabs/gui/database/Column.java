package a2.tabs.gui.database;

public class Column {

    private String name;
    private ColumnType type;
    private int length;
    private boolean nullable;
    private boolean primaryKey;
    private boolean autoIncrement;

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

    public void setName(String name) {
        this.name = name;
    }

    public ColumnType getType() {
        return type;
    }

    public void setType(ColumnType type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    @Override
    public String toString() {
        return "" + name + " " + type + (length != 0 ? "(" + length + ")" : "") + " " + (nullable ? "" : "NOT NULL");
    }
}
