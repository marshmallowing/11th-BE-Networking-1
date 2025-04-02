package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;

import java.util.List;

import static racingcar.view.InputView.enterCar;
import static racingcar.view.InputView.enterRounds;
import static racingcar.view.OutputView.printRaceResults;
import static racingcar.view.OutputView.printWinners;

public class RacingGameService {
    private final CarService carService = new CarService();

    public RacingGame startGame() {
        List<Car> cars = enterCar();
        int rounds = enterRounds();

        return new RacingGame(cars, rounds);
    }

    public void playGame(RacingGame game){
        System.out.println("\n실행 결과");

        for (int i = 0; i < game.getRounds(); i++) {
            for (Car car : game.getCars()) {
                carService.moveCar(car);
            }
            printRaceResults(game.getCars());
        }
        overGame(game.getCars());
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

        printWinners(winners);
    }
}
