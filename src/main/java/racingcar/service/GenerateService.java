package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class GenerateService {
    private static class SingletonGenerateService {
        private static final GenerateService GENERATE_SERVICE = new GenerateService();
    }

    public static GenerateService getInstance() {
        return SingletonGenerateService.GENERATE_SERVICE;
    }

    private GenerateService() {
    }

    public List<Car> generateCars(List<String> CarNames) {
        return CarNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
