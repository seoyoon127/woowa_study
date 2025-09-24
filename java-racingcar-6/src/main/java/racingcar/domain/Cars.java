package racingcar.domain;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames){
        this.cars = carNames.stream().map(Car::new).toList();
    }

    public List<String> getWinners(){
        int maxScore = cars.stream().mapToInt(Car::getScore).max().orElse(0);

        return cars.stream()
                .filter(c -> c.getScore() == maxScore)
                .map(Car::getName)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
