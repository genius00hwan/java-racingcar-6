package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class JudgeService {
    private static class SingletonJudgeService {
        private static final JudgeService JUDGE_SERVICE = new JudgeService();
    }

    public static JudgeService getInstance() {
        return SingletonJudgeService.JUDGE_SERVICE;
    }

    private JudgeService() {
    }

    public List<Car> judge(List<Car> cars) {
        Integer winningLocation = calculateWinningLocation(cars);
        return cars.stream()
                .filter(car -> car.isWinner(winningLocation))
                .collect(Collectors.toList());

    }

    private Integer calculateWinningLocation(List<Car> cars) {
        return cars.stream()
                .map(Car::getCurrentLocation)
                .max(Integer::compareTo)
                .orElse(0);
    }
}
