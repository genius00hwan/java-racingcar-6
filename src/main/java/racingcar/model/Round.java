package racingcar.model;

public class Round {
    private final Integer totalRounds;
    private Integer currentRound;

    public Round(Integer totalRounds) {
        validateNumberOfRounds(totalRounds);
        this.totalRounds = totalRounds;
        currentRound = 1;
    }

    public Boolean hasMoreRound() {
        return (totalRounds >= currentRound);
    }

    public void completeARound() {
        currentRound++;
    }

    public void reset() {
        currentRound = 1;
    }

    public Integer getCurrentRound() {
        return currentRound;
    }

    private void validateNumberOfRounds(Integer numberOfRounds) {
        if (numberOfRounds < 1) {
            throw new IllegalArgumentException();
        }
    }


}
