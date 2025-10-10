package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    public static Integer validateCost(String costStr){
        Integer cost = convertToInt(costStr);
        validateThousandUnit(cost);
        return cost;
    }

    public static Integer convertToInt(String str){
        return Integer.parseInt(str);
    }

    public static void validateThousandUnit(Integer cost){
        if (!isThousandUnit(cost)){
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
        }
    }

    public static boolean isThousandUnit(Integer cost){
        return cost % 1000 == 0;
    }

    public static List<Integer> validateWinNums(String winNumStr){
        return convertToIntList(winNumStr);
    }

    public static List<Integer> convertToIntList(String str){
        return Arrays.stream(str.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
