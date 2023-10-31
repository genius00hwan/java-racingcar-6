package racingcar.model;

public class Car {
    String name;
    Integer location;
    Boolean isWinner;
    Accelerator accelerator;

    public Car(String name) {
        this.name = name;
        accelerator = new Accelerator();
        location = 0;
        isWinner = false;
    }

    public void advance() {
        location += accelerator.advance();
    }

    public Integer getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setWinner() {
        isWinner = true;
    }

    public Boolean isWinner() {
        return isWinner;
    }
}
