package racingcar.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.GenerateService;

public class GenerateServiceTest {
    @Test
    void testGenerateCars() {
        // Given
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");

        // When
        GenerateService generateService = GenerateService.getInstance();
        List<Car> cars = generateService.generateCars(carNames);

        // Then
        assertEquals(carNames.size(), cars.size());

        for (int i = 0; i < carNames.size(); i++) {
            assertEquals(carNames.get(i), cars.get(i).getName());
        }
    }
}
