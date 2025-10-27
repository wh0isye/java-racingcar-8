package Model;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final Cars cars;
    private final int totalRound;
    private static final int MAX_ROUND = 100;

    public void checkRound(int round) {
        if (round > MAX_ROUND) {
            throw new IllegalArgumentException("최대 100번까지 시도 가능합니다.");
        } else if (round <= 0) {
            throw new IllegalArgumentException("최소 1번은 시도해야 합니다.");
        }
    }

    public Racing(Cars cars, int totalRound) {
        checkRound(totalRound);
        this.cars = cars;
        this.totalRound = totalRound;
    }

    public void raceOneRound() {
        cars.moveAllCars();
        cars.updateWinCount();
    }

    public void endOneRound() {
        cars.resetPositions();
    }

    public int getMaxWin() {
        int maxWin = 0;

        for (Car car : cars.getCars()) {
            if (car.getWinCount() > maxWin) {
                maxWin = car.getWinCount();
            }
        }
        return maxWin;
    }

    public List<String> getFinalWinner() {
        int maxWin = getMaxWin();
        List<String> finalWinners = new ArrayList<>();

        for (Car car : cars.getCars()) {
            if (car.getWinCount() == maxWin) {
                finalWinners.add(car.getCarName());
            }
        }
        return finalWinners;
    }

    public int getTotalRound() {
        return totalRound;
    }
}