
package Menu;

public enum MenuItems {
    EXIT("Выход", 0),
    READ_MONTH_REPORTS("Считать все месячные отчеты", 1),
    READ_YEARLY_REPORTS("Считать годовой отчёт", 2),
    CHECK_READINGS("Сверить отчёты", 3),
    DISPLAY_INFORMATION_MONTH("Вывести информацию о всех месячных отчётах", 4),
    DISPLAY_INFORMATION_YEARLY("Вывести информацию о годовом отчёте", 5),
    ERROR("Извините, такой команды пока, что не cуществует.", -1);
    
    private final String title;
    private final int number;
    
    MenuItems(String title, int number) {
        this.title = title;
        this.number = number;
    }
    
    @Override
    public String toString() {
        return "MenuItems{" +
            "title='" + title + '\'' +
            ", number=" + number +
            '}';
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getNumber() {
        return number;
    }
    
    public static MenuItems valueOfItem(String title) {
        for (MenuItems titles : MenuItems.values()) {
            if (titles.title.equals(title)) {
                System.out.println(titles);
                return titles;
            }
        }
        throw new RuntimeException("Ошибка кода");
    }
    
    public static MenuItems valueOfNuber(int number) {
        for (MenuItems numbers : MenuItems.values()) {
            if (numbers.getNumber() == number) {
                return numbers;
            }
        }
        return MenuItems.ERROR;
    }
}


