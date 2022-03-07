package Records;
import Util.YearlyReport;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class YearlyReportReader {
    public static ArrayList<YearlyReport> yearlyReports = new ArrayList<>();
    private static String readCSVile(String path) { //Read CSV file
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с годовым отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public static void readYearlyReports() { // Read Line yearly Report
        yearlyReports.clear();
        int reportsCount = 0;
        String fileContents = readCSVile("resources/y.2021.csv");
        if (fileContents == null) {
            System.out.println("Ошибка файл пустой");
            return;
        }
            List<String> reports = List.of(fileContents.split("\\n"));
            for (int i = 1; i < reports.size(); i++) {
                List<String> lineContents = List.of(reports.get(i).split(","));
                YearlyReport yearlyReport = new YearlyReport(
                        2021,
                        Integer.parseInt(lineContents.get(0)),
                        Integer.parseInt(lineContents.get(1)),
                        lineContents.get(2).equals("TRUE"));
                yearlyReports.add(yearlyReport);
            }
        reportsCount++;
        if (yearlyReports.size() != 0) {
            System.out.printf("Успешно считано %d отчетов\n", reportsCount);
        } else {
            System.out.println("Не удалось считать отчеты");
        }
    }
}