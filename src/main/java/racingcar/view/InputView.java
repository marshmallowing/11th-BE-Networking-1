package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.List;

import static racingcar.util.Validator.validateCarNames;
import static racingcar.util.Validator.validateRounds;

public class InputView {
    public static List<Car> enterCar(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine().trim();
        List<String> carNames = validateCarNames(input);

        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public static int enterRounds(){
        System.out.println("시도할 회수는 몇회인가요?");
        String roundInput = Console.readLine().trim();
        return validateRounds(roundInput);
    }
}
