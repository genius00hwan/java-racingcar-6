package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";



    private static class SingletonOutputView {
        private static final OutputView OUTPUT_VIEW = new OutputView();
    }

    public static OutputView getInstance() {
        return SingletonOutputView.OUTPUT_VIEW;
    }

    private OutputView() {

    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }
    public void printStatusOfARound(Map<String,Integer> carLocations) {
        for(String carName : carLocations.keySet()){
            printCarStatusOfARound(carName,carLocations.get(carName));
        }
        System.out.println();
    }



    public void printWinners(List<String> winningCarNames) {
        System.out.print("최종 우승자 : ");
        while (!winningCarNames.isEmpty()) {
            System.out.print(winningCarNames.get(0));
            winningCarNames.remove(0);
            if (!winningCarNames.isEmpty()) {
                System.out.print(", ");
            }
        }
    }
    private void printCarStatusOfARound(String carName, Integer location) {
        System.out.print(carName + " : ");
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
