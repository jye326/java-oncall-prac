package oncall;

import oncall.controller.OncallController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OncallController controller = new OncallController();
        controller.start();
    }
}
