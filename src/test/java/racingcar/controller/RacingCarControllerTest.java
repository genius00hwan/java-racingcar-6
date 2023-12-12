package racingcar.controller;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import racingcar.service.GenerateService;
import racingcar.service.JudgeService;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import racingcar.model.Car;
import racingcar.model.Round;

import java.util.ArrayList;
import java.util.List;

public class RacingCarControllerTest {

    private RacingCarController racingCarController;
    private InputView inputView;
    private OutputView outputView;
    private GenerateService generateService;
    private RaceService raceService;
    private JudgeService judgeService;

    @BeforeEach
    void setup() {
        racingCarController = RacingCarController.getInstance();
        inputView = mock(InputView.class);
        outputView = mock(OutputView.class);
        generateService = mock(GenerateService.class);
        raceService = mock(RaceService.class);
        judgeService = mock(JudgeService.class);

        racingCarController.inputView = inputView;
        racingCarController.outputView = outputView;
        racingCarController.generateService = generateService;
        racingCarController.raceService = raceService;
        racingCarController.judgeService = judgeService;
    }

    @Test
    void testRun() {
        List<Car> cars = new ArrayList<>();
        Round round = new Round(5);
        List<Car> completedCars = new ArrayList<>();
        List<Car> winningCars = new ArrayList<>();

        when(inputView.inputCarNames()).thenReturn(List.of("car1", "car2", "car3"));
        when(generateService.generateCars(List.of("car1", "car2", "car3"))).thenReturn(cars);
        when(inputView.inputTotalRounds()).thenReturn(5);
        when(raceService.race(round, cars)).thenReturn(completedCars);
        when(judgeService.judge(completedCars)).thenReturn(winningCars);

        racingCarController.run();

        verify(outputView).printResultMessage();
        verify(outputView, times(5)).printStatusOfARound(any());
        verify(outputView).printWinners(any());
    }
}
