package a2.tabs.gui.database;

public class ColumnList {

    private final Column[] columns;

    public ColumnList(Column[] columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Column column : columns) {
            sb.append(column.toString());
            if (column != columns[columns.length - 1]) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}