package oncall.util;

public enum OUTPUT_MESSAGE {
    // 일반 정적 출력 문구 예시
    ASK_MONTH_START_DAY("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
    openingComment("안녕하세요. W편의점입니다.\n현재 보유하고 있는 상품입니다.\n"),
    divider("===================================="),
    doubleTab("\t\t"),
    // format 사용한 가변 출력 문구 예시
    PAY_AMOUNT("내실돈\t\t\t %s");
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