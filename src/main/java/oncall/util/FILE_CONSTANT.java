package oncall.util;

public enum FILE_CONSTANT {
    HOLLY_DAYS_FILEPATH("src/main/java/oncall/hollydays.md"),
    MONTH_DELIMITER(":"),
    DAY_DELIMITER(","),
    FILE_DELIMITER("\n"),

    dateFormat_yyyyMMdd("yyyy-MM-dd");

    private final String path;

    FILE_CONSTANT(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}