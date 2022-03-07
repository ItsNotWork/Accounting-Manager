package Util;

import Records.MonthlyReportReader;
import Records.YearlyReportReader;

public class Library {
    public static void checkNull() { //Check reports to write file
        if (YearlyReportReader.yearlyReports.size() == 0 || MonthlyReportReader.mounthlyReports.size() == 0) {
            System.out.println("Необходимо считать отчеты!");
        }
    }
}
