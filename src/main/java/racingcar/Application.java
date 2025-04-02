package racingcar;

import racingcar.domain.RacingGame;
import racingcar.service.RacingGameService;

public class Application {
    public static void main(String[] args) {
        RacingGameService racingGameService = new RacingGameService();
        RacingGame game = racingGameService.startGame();
        racingGameService.playGame(game);
    }
}