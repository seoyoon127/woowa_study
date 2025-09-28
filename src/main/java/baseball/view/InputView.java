package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    static String START_MSG = "숫자 야구 게임을 시작합니다.";
    static String INPUT_MSG = "숫자를 입력해주세요 : ";

    public void print_start(){
        System.out.println(START_MSG);
    }

    public List<Integer> input_numbers(){
        System.out.println(INPUT_MSG);
        String inputNum = Console.readLine();
        return Validation.validateNumber(inputNum);
    }

    private static class Validation{

        public static List<Integer> validateNumber(String inputNum){
            validateIsNumber(inputNum);
        }

        // 입력값이 숫자가 맞는지 검증
        public static void validateIsNumber(String inputNum){
            if (!isNumber(inputNum)){
                throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
            }
        }

        public static boolean isNumber(String inputNum){
            try {
                Integer.parseInt(inputNum);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        // 3자리 수인지 검증

        // 리스트로 저장

        // 서로 다른 수로 구성되었는지 검증
        // 게임 끝난 후, 입력값이 1 또는2인지 검증
    }
}
