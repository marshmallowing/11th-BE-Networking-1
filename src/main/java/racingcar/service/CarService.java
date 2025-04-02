package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

public class CarService {

    public void moveCar(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if (randomNumber>= 4) {
            car.move();
        }
    }

    public String getCarStatus(Car car) {
        return car.getCarName() + " : " + "-".repeat(car.getPosition());
    }
}

