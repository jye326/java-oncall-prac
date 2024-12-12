package oncall.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import oncall.util.FILE_CONSTANT;
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
        printDays();
    }

    private void printDays() {
        for (int i = 0; i < count_day; i++) {
            System.out.print(days[i]);
        }
    }

    private int getCount_day(int monthInt) {
        //각 월이 몇일 까지 있냐
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 31);
        map.put(2, 28);
        map.put(3, 31);
        map.put(4, 30);
        map.put(5, 31);
        map.put(6, 30);
        map.put(7, 31);
        map.put(8, 31);
        map.put(9, 30);
        map.put(10, 31);
        map.put(11, 30);
        map.put(12, 31);
        return map.get(monthInt);
    }

    private void updateDays() {
        for (int i = 0; i < count_day; i++, startDayIndex++) {
            days[i] = (startDayIndex % 7);
        }
    }

    private void checkHollyDays() {
        String hollydaysString = FileInputView.readHollyDayFileToString();
        Scanner scanner = new Scanner(hollydaysString);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int month = Integer.parseInt(line.split(FILE_CONSTANT.MONTH_DELIMITER.toString())[0]);
            if (monthInt == month) {
                updateHollyDays(line.split(FILE_CONSTANT.MONTH_DELIMITER.toString())[1]);
            }
        }
    }

    private void updateHollyDays(String hollyDays) {
        List<String> hollyDayList = Arrays.stream(hollyDays.split(FILE_CONSTANT.DAY_DELIMITER.toString())).toList();
        for (String day : hollyDayList) {
            int dayInt = Integer.parseInt(day);
            if (this.days[dayInt-1] < 5) {    // 그날이 평일이면
                this.days[dayInt-1] = 7;  // 법정 공휴일 7로 지정
            }
        }
    }


    private boolean isWeekDay(int dayIndex) {
        return days[dayIndex-1] < 5;
    }

    private boolean isHollyDay(int dayIndex) {
        return days[dayIndex-1] == 7;
    }

}
