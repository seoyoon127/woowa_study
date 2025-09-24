package racingcar;

import racingcar.controller.GameController;
import racingcar.utils.MoveStrategy;
import racingcar.utils.RandomMove;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MoveStrategy randomMove = new RandomMove();

        GameController gameController = new GameController(inputView, outputView, randomMove);
        gameController.play();
    }
}
