package oncall.model;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import oncall.util.NUMBER_CONSTANT;

public class OncallTable {
    private int[] days;
    private Deque<String> weekDaysCrew;
    private Deque<String> hollyDaysCrew;

    public OncallTable(int[] days, Deque<String> weekDaysCrew, Deque<String> hollyDaysCrew) {
        this.days = days;
        this.weekDaysCrew = weekDaysCrew;
        this.hollyDaysCrew = hollyDaysCrew;
    }

    public List<String> patchOnCall() {
        List<String> result = new ArrayList<>();
        for (int i = NUMBER_CONSTANT.ZERO.getInt(); i < days.length; i++) {
            if (isWeekDay(i)) {
                addWeekDay(i, result);
                continue;
            }
            addHollyDay(i, result);
        }
        return result;
    }

    private void addWeekDay(int i, List<String> result) {
        if (!result.isEmpty() && result.get(i - NUMBER_CONSTANT.ONE.getInt()).equals(weekDaysCrew.peekFirst())) {
            String nowCrew = weekDaysCrew.removeFirst();
            String nextCrew = weekDaysCrew.removeFirst();
            result.add(nextCrew);
            weekDaysCrew.addLast(nextCrew);
            weekDaysCrew.addFirst(nowCrew);
            return;
        }
        String nowCrew = weekDaysCrew.removeFirst();
        result.add(nowCrew);
        weekDaysCrew.addLast(nowCrew);
    }

    private void addHollyDay(int i, List<String> result) {
        if (!result.isEmpty() && result.get(i - NUMBER_CONSTANT.ONE.getInt()).equals(hollyDaysCrew.peekFirst())) {
            String nowCrew = hollyDaysCrew.removeFirst();
            String nextCrew = hollyDaysCrew.removeFirst();
            result.add(nextCrew);
            hollyDaysCrew.addLast(nextCrew);
            hollyDaysCrew.addFirst(nowCrew);
            return;
        }
        String nowCrew = hollyDaysCrew.removeFirst();
        result.add(nowCrew);
        hollyDaysCrew.addLast(nowCrew);
    }


    private boolean isWeekDay(int dayIndex) {
        return days[dayIndex] < NUMBER_CONSTANT.FIVE.getInt();
    }

    private boolean isHollyDay(int dayIndex) {
        return days[dayIndex] >= NUMBER_CONSTANT.SEVEN.getInt();
    }

}
