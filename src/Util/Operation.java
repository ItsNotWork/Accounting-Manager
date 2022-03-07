package Util;

import Records.MonthlyReportReader;
import Records.YearlyReportReader;

public class Operation {
    public static void compareReports() {
        Library.checkNull();
        for (YearlyReport yearlyReport : YearlyReportReader.yearlyReports) {
            if (!yearlyReport.IsExpense()) {
                if (yearlyReport.getAmount() == MonthlyReport.getIncomeExpensesMount(MonthlyReportReader.mounthlyReports, yearlyReport.getNumberMount(), false)) {
                    System.out.printf("\n%s\nОтчет по доходу сходится, ошибок нет\nСумма дохода в годовом отсчете: %d\nСумма дохода в месячном отсчете: %d\n",
                            yearlyReport.getNameMount(),
                            yearlyReport.getAmount(),
                            MonthlyReport.getIncomeExpensesMount(MonthlyReportReader.mounthlyReports, yearlyReport.getNumberMount(), false));
                } else {
                    System.out.printf("\n%s\nОтчет по доходу не сходится\nСумма дохода в годовом отсчете %d\nСумма дохода в месячном отсчете %d\n",
                            yearlyReport.getNameMount(),
                            yearlyReport.getAmount(),
                            MonthlyReport.getIncomeExpensesMount(MonthlyReportReader.mounthlyReports, yearlyReport.getNumberMount(), false));
                }
            } else {
                if (yearlyReport.getAmount() == MonthlyReport.getIncomeExpensesMount(MonthlyReportReader.mounthlyReports, yearlyReport.getNumberMount(), true)) {
                    System.out.printf("Отчет по расходам сходится, ошибок нет\nСумма расхода в годовом отсчете: %d\nСумма расходов в месячном отсчете: %d\n",
                            yearlyReport.getAmount(),
                            MonthlyReport.getIncomeExpensesMount(MonthlyReportReader.mounthlyReports, yearlyReport.getNumberMount(), true));
                } else {
                    System.out.printf("\n%s\nОтчет по расходам не сходится\nСумма расходов в годовом отсчете %d\nСумма расходов в месячном отсчете %d\n",
                            yearlyReport.getNameMount(),
                            yearlyReport.getAmount(),
                            MonthlyReport.getIncomeExpensesMount(MonthlyReportReader.mounthlyReports, yearlyReport.getNumberMount(), true));
                }
            }
        }
    }


    public static void getInformationByMonths() {
        Library.checkNull();
        for (YearlyReport yearlyReport : YearlyReportReader.yearlyReports) {
            if (!yearlyReport.IsExpense()) {
                System.out.printf("За месяц %s cамый прибыльный товар - %s \nПродано на сумму %d\n",
                        yearlyReport.getNameMount(),
                        MonthlyReport.getNameBestMonth(MonthlyReportReader.mounthlyReports, yearlyReport.getNumberMount(), false),
                        MonthlyReport.getBestIncomeExpensesMount(MonthlyReportReader.mounthlyReports, yearlyReport.getNumberMount(), false));
                System.out.printf("Самый убыточный товар  - %s \nТрата составила  %d\n",
                        MonthlyReport.getNameBestMonth(MonthlyReportReader.mounthlyReports, yearlyReport.getNumberMount(), true),
                        MonthlyReport.getBestIncomeExpensesMount(MonthlyReportReader.mounthlyReports, yearlyReport.getNumberMount(), true));
            }
        }
    }

    public static void getMatYearly() {
      Library.checkNull();
        for (YearlyReport yearlyReport : YearlyReportReader.yearlyReports) {
            if (!yearlyReport.IsExpense()) {
                System.out.printf("Прибыль за %s %d года составила:\t%d\n",
                        yearlyReport.getNameMount(),
                        yearlyReport.getYear(),
                        YearlyReport.getBalanceForMonth(YearlyReportReader.yearlyReports, yearlyReport.getNumberMount()));
            }
        }
        System.out.printf("Средний расход за все месяцы в году составил: %.2f\n",
                YearlyReport.getAverageYearly(YearlyReportReader.yearlyReports, true));
        System.out.printf("Средний доход за все месяцы в году составил: %.2f\n",
                YearlyReport.getAverageYearly(YearlyReportReader.yearlyReports, false));
    }
}