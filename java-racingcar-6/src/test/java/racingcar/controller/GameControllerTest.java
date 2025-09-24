package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.utils.TestAlwaysMove;
import racingcar.utils.TestNeverMove;
import racingcar.view.InputView;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
class GameControllerTest {
    @Test
    void run_canMove(){
        Car car = new Car("car");
        GameController controller = new GameController(new InputView(), new TestAlwaysMove());

        controller.run(car);

        assertThat(car.getScore()).isEqualTo(1);

    }

    @Test
    void run_cantMove(){
        Car car = new Car("car");
        GameController controller = new GameController(new InputView(), new TestNeverMove());

        controller.run(car);

        assertThat(car.getScore()).isEqualTo(0);

    }
  
}