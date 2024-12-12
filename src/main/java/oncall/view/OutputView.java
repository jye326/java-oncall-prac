package oncall.view;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import oncall.util.DAY_CONSTANT;
import oncall.util.NUMBER_CONSTANT;
import oncall.util.OUTPUT_MESSAGE;


public class OutputView {


    public static void printResult(int month, int[] days, List<String> table) {
        for (int i = 0; i < days.length; i++) {
            String temp = OUTPUT_MESSAGE.EMPTY.toString();
            temp += month;
            temp += OUTPUT_MESSAGE.MONTH_CONSTANT.toString();
            temp += String.valueOf(i + NUMBER_CONSTANT.ONE.getInt());
            temp += OUTPUT_MESSAGE.DAY_CONSTANT.toString();
            temp += indexToDay(days[i]) + OUTPUT_MESSAGE.SPACE;
            temp += table.get(i);
            System.out.println(temp);
        }
    }

    private static String indexToDay(int i) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(NUMBER_CONSTANT.ZERO.getInt(), DAY_CONSTANT.MONDAY.getDay());
        map.put(NUMBER_CONSTANT.ONE.getInt(), DAY_CONSTANT.TUESDAY.getDay());
        map.put(NUMBER_CONSTANT.TWO.getInt(), DAY_CONSTANT.WEDNESDAY.getDay());
        map.put(NUMBER_CONSTANT.THREE.getInt(), DAY_CONSTANT.THURSDAY.getDay());
        map.put(NUMBER_CONSTANT.FOUR.getInt(), DAY_CONSTANT.FRIDAY.getDay());
        map.put(NUMBER_CONSTANT.FIVE.getInt(), DAY_CONSTANT.SATURDAY.getDay());
        map.put(NUMBER_CONSTANT.SIX.getInt(), DAY_CONSTANT.SUNDAY.getDay());
        for (int j = NUMBER_CONSTANT.ZERO.getInt(); j < NUMBER_CONSTANT.SEVEN.getInt(); j++) {
            map.put(NUMBER_CONSTANT.SEVEN.getInt()+i, map.get(i) + OUTPUT_MESSAGE.HOLLY_DAY_SUFFIX);
        }
        return map.get(i);
    }


}