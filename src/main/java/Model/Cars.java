package Model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Cars {
    private final List<Car> carList;
    private static final int MAX_CAR_COUNT = 10;

    public void checkCarCount(List<Car> carList) {
        if (carList.size() > MAX_CAR_COUNT) {
            throw new IllegalArgumentException("최대 자동차 수는 " + MAX_CAR_COUNT + " 입니다.");
        }
    }

    public Cars(List<Car> carList) {
        checkCarCount(carList);
        this.carList = carList;
    }

    public void moveAllCars() {
        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public List<Car> getCars() {
        return carList;
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : carList) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}
