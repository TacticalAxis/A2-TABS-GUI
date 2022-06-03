package a2.tabs.gui.util;

public class MessageStringifier {

    public static String shorten(String text, int max) {
        if (text.length() <= max) {
            return text;
        }

        return text.substring(0, max) + "...";
    }

    public String sanitise(String text) {
        return text.replace("'", "").replace("\"", "");
    }
}