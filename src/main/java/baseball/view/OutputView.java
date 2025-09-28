package baseball.view;

public class OutputView {
    static String START_MSG = "숫자 야구 게임을 시작합니다.";
    static String THREE_STRIKE_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void print_start(){
        System.out.println(START_MSG);
    }

    public void print_result(Integer strike, Integer ball){
        StringBuilder sb = new StringBuilder();
        if (ball > 0){
            sb.append(ball).append("볼 ");
        }
        if (strike > 0){
            sb.append(strike).append("스트라이크");
        }
        System.out.println(sb.toString());
    }

    public void print_three_strike(){
        System.out.println(THREE_STRIKE_MSG);
    }
}
