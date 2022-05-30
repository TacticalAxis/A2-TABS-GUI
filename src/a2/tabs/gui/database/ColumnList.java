package a2.tabs.gui.database;

public class ColumnList {

    private Column[] columns;

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

    public static void main(String[] args) {
        Column[] columns = new Column[] {
                new Column("id", ColumnType.INTEGER, 0, false, true, true),
                new Column("name", ColumnType.STRING, 500, false, false, false)
        };

        ColumnList columnList = new ColumnList(columns);

        System.out.println(columnList);
    }
}