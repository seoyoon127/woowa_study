package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static final String RESULT_NOTICE = "실행 결과";

    public void printResultNotice(){
        System.out.println(RESULT_NOTICE);
    }

    public void printResult(Car car){
        System.out.println(car.getName() + " : " + "-".repeat(car.getScore()));
    }

    public void printLine(){
        System.out.println();
    }

    public void printWinner(List<String> winners){
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
