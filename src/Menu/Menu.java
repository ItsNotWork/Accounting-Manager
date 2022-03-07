package Menu;

import Records.MonthlyReportReader;
import Records.YearlyReportReader;
import Util.Operation;

import java.util.Scanner;

public class Menu {
    public static void menus() {
        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            switch (readMenuItem(scanner)) {
                case READ_MONTH_REPORTS:
                    MonthlyReportReader.readMonthlyReports();
                    break;
                case READ_YEARLY_REPORTS:
                    YearlyReportReader.readYearlyReports();
                    break;
                case CHECK_READINGS:
                    Operation.compareReports();
                    break;
                case DISPLAY_INFORMATION_MONTH:
                    Operation.getInformationByMonths();
                    break;
                case DISPLAY_INFORMATION_YEARLY:
                    Operation.getMatYearly();
                    break;
                case EXIT:
                    return;
                default:
                    System.out.println("Извините, такой команды пока, что не cуществует.");
                    break;
            }
        }
    }
    
    public static MenuItems readMenuItem(Scanner scanner) {
        MenuItems item;
        String line = scanner.next();
        try {
            int buff = Integer.parseInt(line);
            item = MenuItems.valueOfNuber(buff);
        } catch (Exception e) {
            item = MenuItems.ERROR;
        }
        return item;
    }
    
    public static void printMenu() {
        System.out.println();
        System.out.println("Что вы хотите сделать? ");
        System.out.printf("%s - %s%n", MenuItems.READ_MONTH_REPORTS.getNumber(), MenuItems.READ_MONTH_REPORTS.getTitle());
        System.out.printf("%s - %s%n", MenuItems.READ_YEARLY_REPORTS.getNumber(), MenuItems.READ_YEARLY_REPORTS.getTitle());
        System.out.printf("%s - %s%n", MenuItems.CHECK_READINGS.getNumber(), MenuItems.CHECK_READINGS.getTitle());
        System.out.printf("%s - %s%n", MenuItems.DISPLAY_INFORMATION_MONTH.getNumber(), MenuItems.DISPLAY_INFORMATION_MONTH.getTitle());
        System.out.printf("%s - %s%n", MenuItems.DISPLAY_INFORMATION_YEARLY.getNumber(), MenuItems.DISPLAY_INFORMATION_YEARLY.getTitle());
        System.out.printf("%s - %s%n", MenuItems.EXIT.getNumber(), MenuItems.EXIT.getTitle());
        System.out.print("Введите команду: ");
    }
}