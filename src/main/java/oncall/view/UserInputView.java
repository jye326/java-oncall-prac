package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oncall.util.ERROR_MESSAGE;
import oncall.util.REGEX_PATTERN;


public class UserInputView {

    // [0] -> month값, [1] -> 시작 요일 인덱스
    public static int[] readMonth_StartDay() {
        int[] month_StartDay = new int[2];
        String ret;
        while (true) {
            try {
                ret = validateMonth_StartDayPattern(Console.readLine());
                month_StartDay[0] = validateMonth(ret);
                month_StartDay[1] = validateStartDay(ret);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return month_StartDay;
    }

    // 정규식 사용한 입력 검증
    private static String validateMonth_StartDayPattern(String inputString) {
        Pattern pattern = Pattern.compile(REGEX_PATTERN.MONTH_STARTDAY_PATTERN.getRegexPattern());
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.matches()) {
            return inputString;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE.INPUT_FORMAT_ERROR.toString());
    }

    private static int validateMonth(String inputString) {
        int month = Integer.parseInt(inputString.split(",")[0]);
        if (1 <= month && month <= 12) {
            return month;
        }
        System.out.println("여기2");
        throw new IllegalArgumentException(ERROR_MESSAGE.INPUT_FORMAT_ERROR.toString());
    }
    // 월 ~일 중에 하나인지
    private static int validateStartDay(String inputString) {
        String startDayString = inputString.split(",")[1];
        HashMap<String,Integer> dayIndexMap = new HashMap<>();
        dayIndexMap.put("월", 0);
        dayIndexMap.put("화", 1);
        dayIndexMap.put("수", 2);
        dayIndexMap.put("목", 3);
        dayIndexMap.put("금", 4);
        dayIndexMap.put("토", 5);
        dayIndexMap.put("일", 6);
        if ("월화수목금토일".contains(startDayString)) {
            return dayIndexMap.get(startDayString);
        }
        System.out.println("여기3");
        throw new IllegalArgumentException(ERROR_MESSAGE.INPUT_FORMAT_ERROR.toString());
    }
}
