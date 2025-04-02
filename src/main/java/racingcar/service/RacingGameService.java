package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

import java.util.List;

import static racingcar.util.Validator.validateCarNames;
import static racingcar.util.Validator.validateRounds;

public class RacingGameService {
    private final CarService carService = new CarService();

    public RacingGame startGame() {
        List<Car> cars = enterCar();
        int rounds = enterRounds();

        return new RacingGame(cars, rounds);
    }

    public List<Car> enterCar(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine().trim();
        List<String> carNames = validateCarNames(input);

        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public int enterRounds(){
        System.out.println("시도할 회수는 몇회인가요?");
        String roundInput = Console.readLine().trim();
        return validateRounds(roundInput);
    }

    public void playGame(RacingGame game){
        System.out.println("\n실행 결과");

        for (int i = 0; i < game.getRounds(); i++) {
            for (Car car : game.getCars()) {
                carService.moveCar(car);
            }
            printRaceResults(game.getCars());
            System.out.println();
        }
        overGame(game.getCars());
    }

    private void printRaceResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(carService.getCarStatus(car));
        }
    }

    public void overGame(List<Car> cars) {
        // 가장 큰 position 찾기
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        // 우승자 찾기
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getCarName)
                .toList();

        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
