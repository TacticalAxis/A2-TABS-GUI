package a2.tabs.gui.util;

import java.util.List;

public class Debug {

    public static List<String> debug;

    // logging method
    public static void log(String message) {
        if (debug != null) {
            debug.add(message);
        }
    }
}