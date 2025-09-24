package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    void setup(){
        car = new Car("car");
    }

    @Test
    void checkDefaultScore(){
        assertThat(car.getScore()).isEqualTo(0);
    }
    @Test
    void moveTest(){
        car.move();
        assertThat(car.getScore()).isEqualTo(1);
    }
}