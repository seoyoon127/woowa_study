package Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


public class InputValidator {
    public static Integer LOTTO_NUM = 6;

    public static Integer validateCost(String strCost){
        Integer cost = convertToInteger(strCost);
        validateThousandUnit(cost);
        return cost;
    }

    public static List<Integer> validateLottoList(String strLotto){
        List<Integer> lottoList = convertToIntList(strLotto);
        validateLength(lottoList);
        validateDuplicate(lottoList);
        for (Integer lottoNum :lottoList){
            validateNumRange(lottoNum);
        }
        return lottoList;
    }

    public static Integer validateBonusNum(String strBonus){
        Integer bonus = convertToInteger(strBonus);
        validateNumRange(bonus);
        return bonus;
    }

    public static Integer convertToInteger(String str){
        return Integer.parseInt(str);
    }

    public static void validateThousandUnit(Integer cost){
        if (!isThousandUnit(cost)){
            throw new IllegalArgumentException("[ERROR] 금액은 1000단위로 입력해주세요.");
        }
    }

    public static boolean isThousandUnit(Integer cost){
        return cost % 1000 == 0;
    }

    public static List<Integer> convertToIntList(String str){
        return Arrays.stream(str.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void validateNumRange(Integer lottoNum){
        if (!isInRange(lottoNum)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static boolean isInRange(Integer lottoNum){
        return lottoNum >= 1 && lottoNum <= 45;
    }

    public static void validateLength(List<Integer> lottoList){
        if (!isLengthValid(lottoList)){
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d개를 입력하셔야 합니다.", LOTTO_NUM));
        }
    }

    public static boolean isLengthValid(List<Integer> lottoList){
        return lottoList.size() == LOTTO_NUM;
    }

    public static void validateDuplicate(List<Integer> lottoList){
        if (isDuplicated(lottoList)){
            throw new IllegalArgumentException("[ERROR] 중복 번호가 있어서는 안 됩니다.");
        }
    }

    public static boolean isDuplicated(List<Integer> lottoList){
        return new HashSet<>(lottoList).size() != LOTTO_NUM;
    }

}
