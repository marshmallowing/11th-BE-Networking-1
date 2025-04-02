package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int rounds;

    public RacingGame(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRounds() {
        return rounds;
    }
}
