package Records;
import Util.MonthlyReport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;

public class MonthlyReportReader {
    public static ArrayList<MonthlyReport> mounthlyReports = new ArrayList<>();
    private static String readCSVile(String path) { //Read CSV file
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public static void readMonthlyReports() { //Read Line monthly Report
        mounthlyReports.clear();
        int reportsCount = 0;
        for (int i = 1; i <= 3; i++) {
            String nameFile = "m.20210" + i + ".csv";
            String fileContents = readCSVile("resources/" + nameFile);
            if (fileContents == null) {
                System.out.println("Ошибка файл пустой");
                return;
            }
                List<String> reports = List.of(fileContents.split("\\n"));
                for (int j = 1; j < reports.size(); j++) {
                    List<String> lineContents = List.of(reports.get(j).split(","));
                    MonthlyReport mounthlyReport = new MonthlyReport(
                            Integer.parseInt(lineContents.get(0)),
                            lineContents.get(1),
                            lineContents.get(2).equals("TRUE"),
                            Integer.parseInt(lineContents.get(3)),
                            Integer.parseInt(lineContents.get(4))
                    );
                    mounthlyReports.add(mounthlyReport);
            } reportsCount++;
        }
        if (mounthlyReports.size() != 0) {
            System.out.printf("Успешно считано %d отчетов\n", reportsCount);
        } else {
            System.out.println("Не удалось считать отчеты");
        }
    }
}