package oncall.controller;

import java.util.Deque;
import java.util.List;
import oncall.domain.Month;
import oncall.model.OncallTable;
import oncall.util.NUMBER_CONSTANT;
import oncall.view.OutputView;
import oncall.view.UserInputView;

public class OncallController {
    public void start() {
        int[] month_StartDayIndex = UserInputView.readMonth_StartDay();
        Month m = new Month(month_StartDayIndex[NUMBER_CONSTANT.ZERO.getInt()], month_StartDayIndex[NUMBER_CONSTANT.ONE.getInt()]);
        List<Deque<String>> crewList = UserInputView.readCrewList();
        OncallTable oncallTable = new OncallTable(m.getDays(), crewList.get(NUMBER_CONSTANT.ZERO.getInt()), crewList.get(NUMBER_CONSTANT.ONE.getInt()));
        List<String> oncallList = oncallTable.patchOnCall();
        OutputView.printResult(m.getMonthInt(), m.getDays(), oncallList);
    }
}
