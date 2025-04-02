package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static void printRaceResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(formatCarStatus(car));
        }
        System.out.println();
    }

    private static String formatCarStatus(Car car) {
        return car.getCarName() + " : " + "-".repeat(car.getPosition());
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
