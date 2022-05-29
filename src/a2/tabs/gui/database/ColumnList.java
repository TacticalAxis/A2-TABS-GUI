package a2.tabs.gui.database;

public class ColumnList {

    private Column[] columns;

    public ColumnList(Column[] columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        Column primaryKey = null;
        for (Column column : columns) {
            if (column.isPrimaryKey()) {
                primaryKey = column;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Column column : columns) {
            sb.append(column);
            if (column.equals(primaryKey) && column.isAutoIncrement()) {
                sb.append(" AUTO_INCREMENT");
            }
            sb.append(", ");
        }
        if (primaryKey != null) {
            sb.append("PRIMARY KEY (");
            sb.append(primaryKey.getName());
            sb.append(") ");
        }

        return sb.toString();
    }

//    public static void main(String[] args) {
//        Column[] columns = new Column[] {
//                new Column("id", ColumnType.INTEGER, 0, false, true, true),
//                new Column("name", ColumnType.STRING, 500, false, false, false)
//        };
//
//        ColumnList columnList = new ColumnList(columns);
//
//        System.out.println(columnList);
//    }
}
