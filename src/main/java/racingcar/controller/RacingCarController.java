package racingcar.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import racingcar.model.Car;
import racingcar.model.Round;
import racingcar.service.RaceService;
import racingcar.service.GenerateService;
import racingcar.service.JudgeService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    InputView inputView;
    OutputView outputView;

    GenerateService generateService;
    RaceService raceService;
    JudgeService judgeService;

    private static class SingletonRacingCarController {
        private static final RacingCarController RACING_CAR_CONTROLLER = new RacingCarController();
    }

    public static RacingCarController getInstance() {
        return SingletonRacingCarController.RACING_CAR_CONTROLLER;
    }

    private RacingCarController() {
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();

        generateService = GenerateService.getInstance();
        raceService = RaceService.getInstance();
        judgeService = JudgeService.getInstance();
    }

    public void run() {
        List<Car> cars = generateCars();
        Round round = generateRound();

        List<Car> completedCars = raceService.race(round, cars);
        showResult(round, completedCars);

        List<Car> winningCars = judgeService.judge(completedCars);
        showWinners(winningCars);
    }


    private List<Car> generateCars() {
        List<String> carNames = inputView.inputCarNames();
        return generateService.generateCars(carNames);
    }

    private Round generateRound() {
        Integer totalRounds = inputView.inputTotalRounds();
        return new Round(totalRounds);
    }


    private void showResult(Round round, List<Car> cars) {
        outputView.printResultMessage();
        round.reset();
        while (round.hasMoreRound()) {
            Integer currentRound = round.getCurrentRound();
            outputView.printStatusOfARound(getRoundStatus(currentRound, cars));
            round.completeARound();
        }
    }

    private Map<String, Integer> getRoundStatus(Integer currentRound, List<Car> cars) {
        return cars.stream().
                collect(Collectors.toMap(Car::getName,
                        car -> car.getLocationOfRound(currentRound)));

    }

    private void showWinners(List<Car> cars) {
        List<String> winningCarNames = cars.stream().map(Car::getName).collect(Collectors.toList());

        outputView.printWinners(winningCarNames);
    }
}
