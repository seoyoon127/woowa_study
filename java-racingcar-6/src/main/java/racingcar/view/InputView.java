package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String CAR_NAMES_NOTICE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`를 출력한다.";
    private static final String RACE_NUMBER_NOTICE = "시도할 회수는 몇회인가요?";
    private static final String DUPLICATE_ERROR_MSG = "자동차 이름이 중복되었습니다.";
    private static final String EMPTY_STRING_MSG = "빈 문자열입니다.";
    private static final String LENGTH_EXCEED_MSG = "자동차 이름은 5글자 이하만 가능합니다.";
    public static final String CAR_NAMES_SEPARATOR = ",";

    public List<String> readNames() {
        System.out.println(CAR_NAMES_NOTICE);
        String value = readLine();
        System.out.println();

        return Validator.validateCarNames(value);
    }

    public int readNumber(){
        System.out.println(RACE_NUMBER_NOTICE);
        String value = readLine();
        System.out.println();

        return Validator.validateNumber(value);
    }

    public static class Validator{
        // 자동차 이름 검증
        public static List<String> validateCarNames(String value){
            validateEmpty(value);
            List<String> cars = parseStringtoList(value);
            validateDuplicated(cars);
            validateLength(cars);
            return cars;
        }

        // 도전 횟수 검증
        public static int validateNumber(String value){
            validateEmpty(value);
            return Integer.parseInt(value);
        }

        // 빈 문자열 검사
        public static void validateEmpty(String string){
            if (isEmpty(string)){
                throw new IllegalArgumentException(EMPTY_STRING_MSG);
            }
        }

        public static boolean isEmpty(String string){
            return string.isEmpty();
        }

        // 중복 검사
        public static void validateDuplicated(List<String> cars){
            if (hasDuplicated(cars)){
                throw new IllegalArgumentException(DUPLICATE_ERROR_MSG);
            }
        }

        public static boolean hasDuplicated(List<String> cars){
            return cars.size() != calculateUniqueCount(cars);
        }

        public static int calculateUniqueCount(List<String> cars){
            return (int) cars.stream()
                    .distinct()
                    .count();
        }

        // 리스트로 변환
        public static List<String> parseStringtoList(String value){
            return Arrays.stream(value.split(CAR_NAMES_SEPARATOR)).toList();
        }

        // 5자 이하인지 검사
        public static void validateLength(List<String> cars){
            for (String car : cars){
                if (isLengthExceed(car)){
                    throw new IllegalArgumentException(LENGTH_EXCEED_MSG);
                }
            }
        }

        public static boolean isLengthExceed(String car){
            return car.length() > 5;
        }

    }

    public String readLine() {
        return Console.readLine();
    }
}
