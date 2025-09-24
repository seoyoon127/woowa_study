package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.MoveStrategy;
import racingcar.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameController {
    private final InputView inputView;

    private MoveStrategy moveStrategy;

    public GameController(InputView inputView, MoveStrategy moveStrategy) {
        this.inputView = inputView;
        this.moveStrategy = moveStrategy;
    }

    public void run(Car car){
        if (moveStrategy.canMove()){
            car.move();
        }
    }

    public void play(){
        List<String> carNames = inputView.readNames();
        Cars cars = new Cars(carNames);
        int tryCount = inputView.readNumber();
        for (int i=0; i<tryCount; i++){
            for (Car car : cars.getCars()){
                run(car);
            }
        }
    }

}
