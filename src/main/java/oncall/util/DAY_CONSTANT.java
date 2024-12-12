package oncall.util;

public enum DAY_CONSTANT {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일"),
    EVERYDAY("월화수목금토일")
    ;

    private final String day;

    DAY_CONSTANT(String day) {
        this.day= day;
    }
    public String getDay() {
        return day;
    }

    @Override
    public String toString() {
        return day;
    }
}
