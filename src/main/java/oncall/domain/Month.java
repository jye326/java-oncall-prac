package oncall.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import oncall.util.FILE_CONSTANT;
import oncall.util.NUMBER_CONSTANT;
import oncall.view.FileInputView;

public class Month {
    private int monthInt;
    private int count_day;
    private int startDayIndex;
    private int[] days; // 일 정보

    public Month(int monthInt, int startDayIndex) {
        this.monthInt = monthInt;
        this.startDayIndex = startDayIndex;
        this.count_day = getCount_day(monthInt);
        this.days = new int[count_day];
        updateDays();
        checkHollyDays();
    }

    public int getMonthInt() {
        return monthInt;
    }


    private int getCount_day(int monthInt) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(NUMBER_CONSTANT.ONE.getInt(), NUMBER_CONSTANT.T1.getInt());
        map.put(NUMBER_CONSTANT.TWO.getInt(), NUMBER_CONSTANT.T8.getInt());
        map.put(NUMBER_CONSTANT.THREE.getInt(), NUMBER_CONSTANT.T1.getInt());
        map.put(NUMBER_CONSTANT.FOUR.getInt(), NUMBER_CONSTANT.T0.getInt());
        map.put(NUMBER_CONSTANT.FIVE.getInt(), NUMBER_CONSTANT.T1.getInt());
        map.put(NUMBER_CONSTANT.SIX.getInt(), NUMBER_CONSTANT.T0.getInt());
        map.put(NUMBER_CONSTANT.SEVEN.getInt(), NUMBER_CONSTANT.T1.getInt());
        map.put(NUMBER_CONSTANT.EIGHT.getInt(), NUMBER_CONSTANT.T1.getInt());
        map.put(NUMBER_CONSTANT.NINE.getInt(), NUMBER_CONSTANT.T0.getInt());
        map.put(NUMBER_CONSTANT.TEN.getInt(), NUMBER_CONSTANT.T1.getInt());
        map.put(NUMBER_CONSTANT.ELEVEN.getInt(), NUMBER_CONSTANT.T0.getInt());
        map.put(NUMBER_CONSTANT.TWELVE.getInt(), NUMBER_CONSTANT.T1.getInt());
        return map.get(monthInt);
    }

    private void updateDays() {
        for (int i = NUMBER_CONSTANT.ZERO.getInt(); i < count_day; i++, startDayIndex++) {
            days[i] = (startDayIndex % NUMBER_CONSTANT.SEVEN.getInt());
        }
    }

    private void checkHollyDays() {
        String hollydaysString = FileInputView.readHollyDayFileToString();
        Scanner scanner = new Scanner(hollydaysString);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int month = Integer.parseInt(line.split(FILE_CONSTANT.MONTH_DELIMITER.toString())[NUMBER_CONSTANT.ZERO.getInt()]);
            if (monthInt == month) {
                updateHollyDays(line.split(FILE_CONSTANT.MONTH_DELIMITER.toString())[NUMBER_CONSTANT.ONE.getInt()]);
            }
        }
    }

    private void updateHollyDays(String hollyDays) {
        List<String> hollyDayList = Arrays.stream(hollyDays.split(FILE_CONSTANT.DAY_DELIMITER.toString())).toList();
        for (String day : hollyDayList) {
            int dayInt = Integer.parseInt(day);
            if (this.days[dayInt - NUMBER_CONSTANT.ONE.getInt()] < NUMBER_CONSTANT.FIVE.getInt()) {    // 그날이 평일이면
                this.days[dayInt - NUMBER_CONSTANT.ONE.getInt()] += NUMBER_CONSTANT.SEVEN.getInt();  // 공휴일은 7 더함
            }
        }
    }

    public int[] getDays() {
        return this.days;
    }

}
