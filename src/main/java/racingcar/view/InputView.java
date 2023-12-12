package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static class SingletonInputView {
        private static final InputView INPUT_VIEW = new InputView();
    }

    public static InputView getInstance() {
        return SingletonInputView.INPUT_VIEW;
    }

    private InputView() {

    }

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userCarNames = Console.readLine();
        List<String> carNames = parseCarNames(userCarNames);

        return carNames;
    }

    public Integer inputTotalRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        String userTotalRounds = Console.readLine();
        Integer totalRounds = Integer.parseInt(userTotalRounds);
        return totalRounds;
    }

    private List<String> parseCarNames(String userCarNames) {
        return Arrays.stream(userCarNames.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateCarNames(List<String> carNames) {
        carNames.stream()
                .filter(String::isEmpty)
                .findAny()
                .ifPresent(emptyCarName -> {
                    throw new IllegalArgumentException();
                });
    }

    private void validateNumberOfRounds(String userNumberOfRounds) {
        userNumberOfRounds.chars()
                .forEach(c -> {
                    if (c < '0' || c > '9') {
                        throw new IllegalArgumentException();
                    }
                });

    }

}
