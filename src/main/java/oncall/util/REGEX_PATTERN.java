package oncall.util;

public enum REGEX_PATTERN {

    // 정규식 테스트 사이트 링크 : https://regex101.com/
    // 정규식 참고 사이트 링크 : https://adjh54.tistory.com/104#google_vignette

    SPACE(" "),
    COMMA(","),
    NAME_LIST_PATTERN("^([가-힣]{1,5},){0,34}[가-힣]{1,5}$"), // 한글영문 2~4자 세트가 ,로 구분되어 총 1~5명세트

    MONTH_STARTDAY_PATTERN("^([0-9]){1,2},[가-힣]$"),


    YN_VALIDATE_PATTERN("[YN]");    // Y또는N, YN은 아님

    private final String regexPattern;

    REGEX_PATTERN(String regexPattern) {
        this.regexPattern = regexPattern;
    }

    public String getRegexPattern() {
        return regexPattern;
    }

}