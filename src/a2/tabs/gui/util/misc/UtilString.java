package a2.tabs.gui.util.misc;

public class UtilString {

    public static String shorten(String text, int max) {
        if (text.length() <= max) {
            return text;
        }

        return text.substring(0, max) + "...";
    }
}
