package a2.tabs.gui.util.misc;

public class UtilSystem {

    public static void exit() {
        // run save operations
//        Debug.log("UtilSystem: exit()");
        saveAll();
        System.out.println("Exiting...");
        System.exit(0);
    }

    public static void saveAll() {
        // save users
//        Debug.log("UtilSystem: saveAll()");
//        UtilFileWrite.writeUsers(User.users);
//        UtilFileWrite.writeCharges(Charge.chargeList);
//        UtilFileWrite.writeMessages(Message.messages);
//        UtilFileWrite.writeLogEntries(Debug.debug);
    }
}