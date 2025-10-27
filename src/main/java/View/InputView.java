package View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static int getTotalRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputRound = Console.readLine();
        int round;

        try {
            round = Integer.parseInt(inputRound);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        if(round <= 0) {
            throw new IllegalArgumentException("자연수 값을 시도할 횟수로 입력해주세요.");
        }
        else {
            return round;
        }
    }
}