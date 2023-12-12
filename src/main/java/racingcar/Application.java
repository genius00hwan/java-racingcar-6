package racingcar;

import racingcar.controller.RacingCarController;

public class Application {
    static RacingCarController racingCarController;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        racingCarController = RacingCarController.getInstance();
        racingCarController.run();
    }
}
