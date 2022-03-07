package Util;

import java.util.ArrayList;

public class YearlyReport {
    private final int year;
    private final int numberMount;
    private String nameMount;
    private final boolean isExpense;
    private final int amount;

    public YearlyReport(int year, int numberMount, int amount, boolean isExpense) {
        this.year = year;
        this.numberMount = numberMount;
        this.amount = amount;
        this.isExpense = isExpense;
    }

    @Override
    public String toString() {
        return "Util.YearlyReport{" +
                "numberMount=" + numberMount +
                ", nameMount='" + nameMount + '\'' +
                ", amount=" + amount +
                ", isExpense=" + isExpense +
                '}';
    }
    public int getYear() {
        return year;
    }
    public int getNumberMount() {
        return numberMount;
    }
    public String getNameMount() {
            nameMount = switch (numberMount) {
                case 1 -> "Январь";
                case 2 -> "Февраль";
                case 3 -> "Март";
                default -> "";
            };
        return nameMount;
    }
    public boolean IsExpense() {
        return isExpense;
    }
    public int getAmount() {
        return amount;
    }
    public static double getAverageYearly(ArrayList<YearlyReport> yearlyReports, boolean isExpense) {
        int sum = 0;
        int numberOfMonths = 0;
        for (YearlyReport yearlyReport : yearlyReports) {
            if (yearlyReport.isExpense == isExpense) {
                sum += yearlyReport.amount;
                numberOfMonths++;
            }
        }
        return sum / numberOfMonths;
    }
    public static int getBalanceForMonth(ArrayList<YearlyReport> yearlyReports, int numberMount) {
        int income = 0;
        int expense = 0;

        for (YearlyReport yearlyReport : yearlyReports) {
            if (!yearlyReport.isExpense && yearlyReport.numberMount == numberMount) {
                income = yearlyReport.amount;
            }
            if (yearlyReport.isExpense && yearlyReport.numberMount == numberMount) {
                expense = yearlyReport.amount;
            }
        }
        return income - expense;
    }
}