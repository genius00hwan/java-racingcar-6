package racingcar.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Round;
import racingcar.service.RaceService;
import java.util.Arrays;
import java.util.List;

public class RaceServiceTest {
    private RaceService raceService;

    @BeforeEach
    public void setup() {
        raceService = RaceService.getInstance();
    }

    @Test
    public void testRace() {
        Integer totalRounds = 5;
        Round round = new Round(totalRounds);
        List<Car> cars = Arrays.asList(
                new Car("Car1"),
                new Car("Car2"),
                new Car("Car3")
        );

        List<Car> completedCars = raceService.race(round, cars);

        Assertions.assertEquals(cars.size(), completedCars.size());
        Assertions.assertEquals(round.getCurrentRound(),totalRounds);
    }

}

