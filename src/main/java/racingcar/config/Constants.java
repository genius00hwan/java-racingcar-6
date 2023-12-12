package racingcar.config;

public enum Constants {
    MAXIMUM_LENGTH_OF_CAR_NAME(5),
    REFERENCE_OF_ADVANCE(4),
    MAXIMUM_OF_RANDOM_NUMBER(9),
    MINIMUM_OF_RANDOM_NUMBER(0),
    ADVANCE_DISTANCE(1),
    STAY_VALUE(0)
    ;
    int value;

    private Constants(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}
