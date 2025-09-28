package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    static String INPUT_MSG = "숫자를 입력해주세요 : ";
    static String END_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public List<Integer> input_numbers(){
        System.out.println(INPUT_MSG);
        String inputNum = Console.readLine();
        return Validation.validateNumber(inputNum);
    }

    public Integer input_endNum(){
        System.out.println(END_MSG);
        String endNum = Console.readLine();
        return Validation.validateEndNum(endNum);
    }

    public static class Validation{

        public static List<Integer> validateNumber(String inputValue){
            validateIsNumber(inputValue);
            validateLength3(inputValue);
            List<Integer> inputList = saveAsList(inputValue);
            validateAllDifferent(inputList);
            return inputList;
        }

        public static Integer validateEndNum(String endNum){
            validateIsNumber(endNum);
            Integer endNumber = Integer.parseInt(endNum);
            validateOneOrTwo(endNumber);
            return endNumber;
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
        public static void validateAllDifferent(List<Integer> inputList){
            if (!isAllDifferent(inputList)){
                throw new IllegalArgumentException("세 자리 모두 다른 숫자로 구성되어야 합니다.");
            }
        }

        public static boolean isAllDifferent(List<Integer> inputList){
            return inputList.size() == new HashSet<>(inputList).size();
        }

        // 게임 끝난 후, 입력값이 1 또는 2인지 검증
        public static void validateOneOrTwo(Integer endNum){
            if (!isOneOrTwo(endNum)){
                throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
            }
        }

        public static boolean isOneOrTwo(Integer endNum){
            return endNum == 1 || endNum == 2;
        }
    }
}
