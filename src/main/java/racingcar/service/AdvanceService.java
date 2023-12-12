package racingcar.service;

import static racingcar.config.Constants.ADVANCE_DISTANCE;
import static racingcar.config.Constants.MAXIMUM_OF_RANDOM_NUMBER;
import static racingcar.config.Constants.MINIMUM_OF_RANDOM_NUMBER;
import static racingcar.config.Constants.REFERENCE_OF_ADVANCE;
import static racingcar.config.Constants.STAY_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Car;

public class AdvanceService {
    private static class SingletonAdvanceService {
        private static final AdvanceService ADVANCE_SERVICE = new AdvanceService();
    }

    public static AdvanceService getInstance() {
        return SingletonAdvanceService.ADVANCE_SERVICE;
    }

    private AdvanceService() {
    }

    public void advanceCars(List<Car> cars) {
        for (Car car : cars) {
            int movingDistance = generateMovingDistance();
            car.move(movingDistance);
        }
    }

    private Integer generateMovingDistance() {
        int randomNumber = Randoms.pickNumberInRange(MINIMUM_OF_RANDOM_NUMBER.get(),
                MAXIMUM_OF_RANDOM_NUMBER.get());
        if (randomNumber > REFERENCE_OF_ADVANCE.get()) {
            return ADVANCE_DISTANCE.get();
        }
        return STAY_VALUE.get();
    }

}
