package Utils;

public class InputValidator {
    public static Integer validateCost(String strCost){
        Integer cost = convertToInteger(strCost);
        validateThousandUnit(cost);
        return cost;
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
}
