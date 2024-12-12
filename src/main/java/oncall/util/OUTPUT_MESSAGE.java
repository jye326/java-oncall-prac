package oncall.util;

public enum OUTPUT_MESSAGE {
    // 일반 정적 출력 문구 예시
    ASK_MONTH_START_DAY("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
    ASK_WEEKDAY_CREW_LIST("평일 비상 근무 순번대로 사원 닉네임을 입력하세요>"),
    ASK_HOLLY_DAY_CREW_LIST("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>"),
    MONTH_CONSTANT("월 "),
    DAY_CONSTANT("일 "),
    SPACE(" "),
    EMPTY(""),
    HOLLY_DAY_SUFFIX("(휴일)"),


    ;
    private final String message;

    OUTPUT_MESSAGE(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    // 주어진 인자를 순서대로 해당 포멧에 채워 넣음
    public String format(Object... args) {
        return String.format(message, args);
    }
}