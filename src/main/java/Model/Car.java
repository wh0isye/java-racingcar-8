package Model;

public class Car {
    private final String carName;
    private int position;

    // Car 객체 생성자
    public Car(String carName) {
        if (carName.length() > 5 || carName.isBlank()) {
            throw new IllegalArgumentException("carName length exceed 5");
        } else {
            this.carName = carName;
            this.position = 0;
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
