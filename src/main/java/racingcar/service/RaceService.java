package racingcar.service;

import static racingcar.config.Constants.ADVANCE_DISTANCE;
import static racingcar.config.Constants.MAXIMUM_OF_RANDOM_NUMBER;
import static racingcar.config.Constants.MINIMUM_OF_RANDOM_NUMBER;
import static racingcar.config.Constants.REFERENCE_OF_ADVANCE;
import static racingcar.config.Constants.STAY_VALUE;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.Car;
import racingcar.model.Round;

public class RaceService {
    private static class SingletonAdvanceService {
        private static final RaceService ADVANCE_SERVICE = new RaceService();
    }

    public static RaceService getInstance() {
        return SingletonAdvanceService.ADVANCE_SERVICE;
    }

    private RaceService() {
    }

    public List<Car> race(Round round, List<Car> cars) {
        List<Car> completedCars = new ArrayList<>();
        while (round.hasMoreRound()) {
            completedCars = advanceCars(cars);
            round.completeARound();
        }
        return completedCars;
    }

    private List<Car> advanceCars(List<Car> cars) {
        for (Car car : cars) {
            int movingDistance = generateMovingDistance();
            car.move(movingDistance);
        }

        return cars;
    }

    private Integer generateMovingDistance() {
        int randomNumber = Randoms.pickNumberInRange(MINIMUM_OF_RANDOM_NUMBER.get(),
                MAXIMUM_OF_RANDOM_NUMBER.get());
        if (randomNumber >= REFERENCE_OF_ADVANCE.get()) {
            return ADVANCE_DISTANCE.get();
        }
        return STAY_VALUE.get();
    }

}
