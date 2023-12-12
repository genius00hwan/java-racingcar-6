package racingcar.Service;


import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.JudgeService;


public class JudgeServiceTest {
    JudgeService judgeService;
    @BeforeEach
    private void preset() {
        judgeService = JudgeService.getInstance();
    }

    @Test
    public void testJudge() {
        List<Car> cars = Arrays.asList(
                new Car("Car1"),
                new Car("Car2"),
                new Car("Car3")
        );


        List<Car> winners = judgeService.judge(cars);

        Assertions.assertEquals(3, winners.size());
        Assertions.assertEquals("Car1", winners.get(0).getName());
        Assertions.assertEquals("Car2", winners.get(1).getName());
        Assertions.assertEquals("Car3", winners.get(2).getName());
    }
}
