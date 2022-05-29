package a2.tabs.gui.model;

import java.util.List;

public class UserOld {
    // users
    public static List<UserOld> userOlds;
    public static UserOld currentUserOld;

    // main attributes
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    // secondary/nullable attributes
    // ird number + salary (adds income tax)
    private String irdNumber;
    private double salary;
    // ownsHome (adds house cv charges, water bill, electricity bill, internet bill)
    private boolean ownsHome;
    // ownsCar (adds road user charges, parking fines, road violation fines)
    private String carRego;

    // constructor
//    public User(String username, ) {
//        this.username = username;
//    }
}