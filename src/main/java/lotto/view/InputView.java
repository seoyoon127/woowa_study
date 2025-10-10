package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.InputValidator;

public class InputView {
    static String COST_INPUT_MSG = "구입금액을 입력해 주세요.";

    public Integer input_cost(){
        while(true){
            try{
                System.out.println(COST_INPUT_MSG);
                String costStr = Console.readLine();
                return InputValidator.validateCost(costStr);
            } catch (NumberFormatException e){
                System.out.println("[ERROR] 올바른 형식의 숫자를 입력해주세요.");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
