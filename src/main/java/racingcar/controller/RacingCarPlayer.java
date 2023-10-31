package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.CarsGenerator;
import racingcar.service.JudgeMachine;
import racingcar.view.Printer;
import racingcar.view.Scanner;

public class RacingCarPlayer implements GamePlayer {
    JudgeMachine judgeMachine;
    CarsGenerator carsGenerator;
    Scanner scanner;
    Printer printer;

    public RacingCarPlayer() {
        scanner = new Scanner();
        printer = new Printer();
        judgeMachine = new JudgeMachine();
        carsGenerator = new CarsGenerator();
    }

    @Override
    public void run() {
        List<Car> carList = generateCars(inputCarNames());
        Integer numberOfRounds = inputNumberOfRounds();
        race(numberOfRounds, carList);
        List<Car> winningCars = judgeMachine.getWinningCars(carList);
        printer.printResult(winningCars);
    }

    private List<Car> generateCars(List<String> carNames) {
        List<Car> carList;
        carList = carsGenerator.generateCars(carNames);
        return carList;
    }

    private Integer inputNumberOfRounds() {
        printer.printInputNumberOfRoundsMessage();
        Integer numberOfRounds = scanner.inputNumberOfRound();
        return numberOfRounds;
    }

    private void race(Integer numberOfRounds, List<Car> carList) {
        printer.printRoundStateMessage();
        for (int round = 1; round <= numberOfRounds; round++) {
            playARound(carList);
            printer.printRoundState(carList);
        }
    }

    private void playARound(List<Car> carList) {
        for (Car car : carList) {
            car.move();
        }
    }

    private List<String> inputCarNames() {
        printer.printInputCarNamesMessage();
        List<String> carNames = scanner.inputCarNames();
        return carNames;
    }
}
