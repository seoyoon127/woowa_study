package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.MoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    private MoveStrategy moveStrategy;

    public GameController(InputView inputView, OutputView outputView,  MoveStrategy moveStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.moveStrategy = moveStrategy;
    }

    public void run(Car car){
        if (moveStrategy.canMove()){
            car.move();
        }
        outputView.printResult(car);
    }

    public void play(){
        List<String> carNames = inputView.readNames();
        Cars cars = new Cars(carNames);
        int tryCount = inputView.readNumber();

        outputView.printResultNotice();
        for (int i=0; i<tryCount; i++){
            for (Car car : cars.getCars()){
                run(car);
            }
            outputView.printLine();
        }
        outputView.printWinner(cars.getWinners());
    }

}
