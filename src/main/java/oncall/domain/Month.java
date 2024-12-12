package oncall.domain;

import java.util.HashMap;

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
            days[i] = (startDayIndex%7);
        }
    }


}
