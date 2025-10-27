package Model;

public class Car {
    private final String carName;
    private int position;
    private int winCount;

    // Car 객체 생성자
    public Car(String carName) {
        if (carName.length() > 5 || carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 1자 이상, 5자 이하로 입력해주세요");
        } else {
            this.carName = carName;
            this.position = 0;
            this.winCount = 0;
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public void addWin() {
        winCount++;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public int getWinCount() {
        return winCount;
    }

    public void resetPosition() {
        position = 0;
    }
}
