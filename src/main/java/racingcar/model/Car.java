package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private List<Integer> locationHistory;

    public Car(String name) {
        validateName(name);
        this.name = name;
        locationHistory = new ArrayList<>();
        locationHistory.add(0);
    }

    public Integer getCurrentLocation() {
        return locationHistory.get(locationHistory.size() - 1);
    }

    public void move(Integer movingDistance) {
        Integer nextLocation = getCurrentLocation() + movingDistance;
        locationHistory.add(nextLocation);
    }

    public Integer getLocationOfRound(Integer round) {
        return locationHistory.get(round);
    }

    private void validateName(String name) {
        if (name.length() >= 5) {
            throw new IllegalArgumentException("잘못된 이름입니다.");
        }
    }

    public Boolean isWinner(Integer winningLocation) {
        return getCurrentLocation().equals(winningLocation);
    }

}
