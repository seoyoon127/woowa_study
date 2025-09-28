package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static class Validation{

        public static List<Integer> validateNumber(String inputValue){
            validateIsNumber(inputValue);
            validateLength3(inputValue);
            List<Integer> inputList = saveAsList(inputValue);
            return inputList;
        }

        // 입력값이 숫자가 맞는지 검증
        public static void validateIsNumber(String inputValue){
            if (!isNumber(inputValue)){
                throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
            }
        }

        public static boolean isNumber(String inputValue){
            try {
                Integer.parseInt(inputValue);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        // 3자리 수인지 검증
        public static void validateLength3(String inputValue){
            if (!isLength3(inputValue)){
                throw new IllegalArgumentException("세자리 숫자를 입력하셔야 합니다.");
            }
        }

        public static boolean isLength3(String inputValue){
            return inputValue.length() == 3;
        }

        // 리스트로 저장
        public static List<Integer> saveAsList(String inputValue){
            return Arrays.stream(inputValue.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }

        // 서로 다른 수로 구성되었는지 검증
        // 게임 끝난 후, 입력값이 1 또는2인지 검증
    }
}
