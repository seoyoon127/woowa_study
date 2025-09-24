package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameController {
    private final InputView inputView;

    public GameController(InputView inputView){
        this.inputView = inputView;
    }

    public void run(Car car){
        if (canMove()){
            car.move();
        }
    }

    public boolean canMove(){
        return Randoms.pickNumberInRange(0,9)>=4;
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
