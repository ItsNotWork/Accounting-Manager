package Util;
import java.util.ArrayList;
public class MonthlyReport {
    private final int numberMount;
    private final String namePurchase;
    private final boolean isExpense;
    private final int quantity;
    private final int price;
    public MonthlyReport(int numberMount, String namePurchase, boolean isExpense, int quantity, int price) {
        this.numberMount = numberMount;
        this.namePurchase = namePurchase;
        this.quantity = quantity;
        this.isExpense = isExpense;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Util.MonthlyReport{" +
                "numberMount=" + numberMount +
                ", namePurchase='" + namePurchase + '\'' +
                ", isExpense=" + isExpense +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
    public static int getIncomeExpensesMount(ArrayList<MonthlyReport> mounthlyReports, int numberMount, boolean isExpense) { // Find mounth Income(isExpense == false), Expenses (isExpense == true)
        int sum = 0;
        for (MonthlyReport mounthlyReport : mounthlyReports) {
            if (mounthlyReport.isExpense == isExpense  && mounthlyReport.numberMount == numberMount) {
                sum += (mounthlyReport.quantity * mounthlyReport.price);
            }
        }
        return sum;
    }

    public static int getBestIncomeExpensesMount(ArrayList<MonthlyReport> mounthlyReports, int  numberMount, boolean isExpense) { //Find best mounth Income(isExpense == false), Expenses (isExpense == true)
        int sum = 0;
        int sumMax = 0;
        for (MonthlyReport mounthlyReport : mounthlyReports) {
            if (mounthlyReport.isExpense == isExpense && mounthlyReport.numberMount == numberMount) {
                sum = (mounthlyReport.quantity * mounthlyReport.price);
                if (sum > sumMax) {
                    sumMax = sum;
                }
            }
        }
        return sumMax;
    }

    public static String getNameBestMonth(ArrayList<MonthlyReport> mounthlyReports, int numberMount, boolean isExpense) { //Find name best mounth Income(isExpense == false), Expenses (isExpense == true)
        int sumMax = 0;
        int sum = 0;
        String nameBestIncome = " ";
        for (MonthlyReport mounthlyReport : mounthlyReports) {
            if (mounthlyReport.isExpense == isExpense && mounthlyReport.numberMount == numberMount) {
                sum = (mounthlyReport.quantity * mounthlyReport.price);
                if (sum > sumMax) {
                    sumMax = sum;
                    nameBestIncome = mounthlyReport.namePurchase;
                }
            }
        }
        return nameBestIncome;
    }
}