package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oncall.util.DAY_CONSTANT;
import oncall.util.ERROR_MESSAGE;
import oncall.util.FILE_CONSTANT;
import oncall.util.NUMBER_CONSTANT;
import oncall.util.OUTPUT_MESSAGE;
import oncall.util.REGEX_PATTERN;
import org.assertj.core.util.Sets;


public class UserInputView {

    // [0] -> month값, [1] -> 시작 요일 인덱스
    public static int[] readMonth_StartDay() {
        int[] month_StartDay = new int[NUMBER_CONSTANT.TWO.getInt()];
        String ret;
        while (true) {
            try {
                System.out.println(OUTPUT_MESSAGE.ASK_MONTH_START_DAY);
                ret = validateMonth_StartDayPattern(Console.readLine());
                month_StartDay[NUMBER_CONSTANT.ZERO.getInt()] = validateMonth(ret);
                month_StartDay[NUMBER_CONSTANT.ONE.getInt()] = validateStartDay(ret);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return month_StartDay;
    }

    public static List<Deque<String>> readCrewList() {
        List<Deque<String>> crewList = new ArrayList<>();
        while (true) {
            try {
                System.out.println(OUTPUT_MESSAGE.ASK_WEEKDAY_CREW_LIST);
                crewList.add(validateDuplicatedCrewName(validateCrewList(Console.readLine())));
                System.out.println(OUTPUT_MESSAGE.ASK_HOLLY_DAY_CREW_LIST);
                crewList.add(validateDuplicatedCrewName(validateCrewList(Console.readLine())));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return crewList;
    }


    // ret에 중복이 있는지 체크, 없으면 deque로 반환
    private static Deque<String> validateDuplicatedCrewName(String ret) {
        List<String> crewList = List.of(ret.split(FILE_CONSTANT.DAY_DELIMITER.toString()));
        Set<String> crewSet = new HashSet<>(crewList);
        if (crewSet.size() != crewList.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE.INPUT_FORMAT_ERROR.toString());
        }
        Deque<String> deque = new LinkedList<>();
        for (String crew : crewList) {
            deque.addLast(crew);
        }
        return deque;
    }

    private static String validateCrewList(String s) {
        Pattern pattern = Pattern.compile(REGEX_PATTERN.NAME_LIST_PATTERN.getRegexPattern());
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            return s;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE.INPUT_FORMAT_ERROR.toString());
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
        int month = Integer.parseInt(inputString.split(FILE_CONSTANT.DAY_DELIMITER.toString())[NUMBER_CONSTANT.ZERO.getInt()]);
        if (1 <= month && month <= 12) {
            return month;
        }

        throw new IllegalArgumentException(ERROR_MESSAGE.INPUT_FORMAT_ERROR.toString());
    }

    // 월 ~일 중에 하나인지
    private static int validateStartDay(String inputString) {
        String startDayString = inputString.split(FILE_CONSTANT.DAY_DELIMITER.toString())[NUMBER_CONSTANT.ONE.getInt()];
        HashMap<String, Integer> dayIndexMap = new HashMap<>();
        dayIndexMap.put(DAY_CONSTANT.MONDAY.getDay(), NUMBER_CONSTANT.ZERO.getInt());
        dayIndexMap.put(DAY_CONSTANT.TUESDAY.getDay(), NUMBER_CONSTANT.ONE.getInt());
        dayIndexMap.put(DAY_CONSTANT.WEDNESDAY.getDay(), NUMBER_CONSTANT.TWO.getInt());
        dayIndexMap.put(DAY_CONSTANT.THURSDAY.getDay(), NUMBER_CONSTANT.THREE.getInt());
        dayIndexMap.put(DAY_CONSTANT.FRIDAY.getDay(), NUMBER_CONSTANT.FOUR.getInt());
        dayIndexMap.put(DAY_CONSTANT.SATURDAY.getDay(), NUMBER_CONSTANT.FIVE.getInt());
        dayIndexMap.put(DAY_CONSTANT.SUNDAY.getDay(), NUMBER_CONSTANT.SIX.getInt());
        if (DAY_CONSTANT.EVERYDAY.getDay().contains(startDayString)) {
            return dayIndexMap.get(startDayString);
        }
        throw new IllegalArgumentException(ERROR_MESSAGE.INPUT_FORMAT_ERROR.toString());
    }
}
