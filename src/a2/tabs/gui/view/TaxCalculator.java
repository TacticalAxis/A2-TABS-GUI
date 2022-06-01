package a2.tabs.gui.view;

import java.util.Arrays;

public class TaxCalculator {

    private final double[] rate;
    private final double[] bracket;
    private final double income;

    public TaxCalculator(double income) {
        this.rate = new double[]{0.105, 0.175, 0.3, 0.33, 0.39};
        this.bracket = new double[]{0, 0, 0, 0, 0};
        this.income = income;

        calculateTax();
    }

    public double getIncome() {
        return income;
    }

    public double[] getBracket() {
        return bracket;
    }

    public double[] getRate() {
        return rate;
    }

    public double[] getTax() {
        double[] tax = new double[5];
        for (int i = 0; i < tax.length; i++) {
            tax[i] = bracket[i] * rate[i];
        }
        return tax;
    }

    // calculate the tax bracket
    public void calculateTax() {
        for (int i = 0; i < income; i++) {
            if (i < 14001) {
                bracket[0]++;
            } else if (i <= 48001) {
                bracket[1]++;
            } else if (i <= 70001) {
                bracket[2]++;
            } else if (i <= 180001) {
                bracket[3]++;
            } else {
                bracket[4]++;
            }
        }
    }

    public double getTotalTax(){
        double totalTax = 0;
        for(int i = 0; i < getTax().length; i++){
            totalTax += getTax()[i];
        }
        return totalTax;
    }

    // get effective tax rate
    public double getEffectiveTaxRate(){
        return getTotalTax()/getIncome();
    }

    public static void main(String[] args) {
        TaxCalculator t = new TaxCalculator(100000);
        System.out.println("Income: $" + t.getIncome());
        System.out.println("Rate: " + Arrays.toString(t.getRate()));
        System.out.println("Bracket: " + Arrays.toString(t.getBracket()));
        System.out.println("Tax: $" + Arrays.toString(t.getTax()));
    }
}