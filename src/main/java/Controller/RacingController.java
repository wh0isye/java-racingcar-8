package Controller;

import Model.*;
import View.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingController {

    public void run() {
        // 1. 사용자 입력 - 자동차 이름
        String inputCarNames = InputView.getCarNames();
        String[] namesArray = inputCarNames.split(",");

        List<String> carNames = new ArrayList<>();
        for (String carName : namesArray) {
            carNames.add(carName.trim());
        }

        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        Cars cars = new Cars(carList);

        // 1. 사용자 입력 - 시도 횟수
        int totalRounds = InputView.getTotalRound();
        Racing racing = new Racing(cars, totalRounds);

        // 2. 경주 진행
        OutputView.printResults();

        for (int i = 0; i < racing.getTotalRound(); i++) {
            racing.raceOneRound();

            // 3. 라운드마다 결과 출력
            OutputView.printRoundResult(cars.getCars());
        }

        // 4. 최종 우승자 출력
        OutputView.printFinalWinner(racing.getFinalWinner());
    }
}
