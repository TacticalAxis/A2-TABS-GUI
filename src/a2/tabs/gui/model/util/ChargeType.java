package a2.tabs.gui.model.util;

public enum ChargeType {
    ELECTRICITY_BILL(1, "Electricity Bill", "Bill to be paid for electricity", 20, true),
    WATER_BILL(2, "Water Bill", "Bill to be paid for water", 20, true),
    INTERNET_BILL(3, "Internet Bill", "Bill to be paid for internet", 20, true),
    ROAD_USER_CHARGES(4, "Road User Charges", "Bill to be paid for road user charges", 20, true),

    PARKING_VIOLATION(5, "Parking Violation", "Bill to be paid for parking violation", 20, true),
    SPEEDING_VIOLATION(6, "Speeding Violation", "Bill to be paid for speeding violation", 1000, true),
    ROAD_VIOLATION(7, "Road Violation", "Bill to be paid for road violation", 20, true);

    private final int id;
    private final String name;
    private final String description;
    private final double amount;
    private final boolean recurring;

    ChargeType(int id, String name, String description, double amount, boolean recurring) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.recurring = recurring;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public static ChargeType getById(int id) {
        for (ChargeType chargeType : ChargeType.values()) {
            if (chargeType.getId() == id) {
                return chargeType;
            }
        }
        return null;
    }
}
