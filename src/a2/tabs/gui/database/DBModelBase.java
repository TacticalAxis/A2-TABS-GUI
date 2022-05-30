package a2.tabs.gui.database;

public class DBModelBase {

    public String getNullableString(Object value) {
        if (value == null || value.toString().isEmpty()) {
            return "NULL";
        }

        return value.toString();
    }
}