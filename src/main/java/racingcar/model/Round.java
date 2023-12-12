package racingcar.model;

public class Round {
    private final Integer numberOfRounds;
    private Integer currentRound;

    public Round(String inputNumberOfRounds) {
        validateNumberOfRounds(inputNumberOfRounds);
        this.numberOfRounds = Integer.parseInt(inputNumberOfRounds);
        currentRound = 0;
    }

    public Boolean hasMoreRound() {
        return (numberOfRounds >= currentRound);
    }

    public void completeARound() {
        currentRound++;
    }

    private void validateNumberOfRounds(String inputNumberOfRounds) {
        if (Integer.parseInt(inputNumberOfRounds) < 0) {
            throw new IllegalArgumentException();
        }
    }
}
