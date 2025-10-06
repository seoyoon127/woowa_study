package lotto.View;

import Utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;


public class InputView {
    static String COST_INPUT_MSG = "구입금액을 입력해 주세요.";

    public Integer input_cost(){
        while(true){
            try{
                System.out.println(COST_INPUT_MSG);
                String strCost = Console.readLine();
                return InputValidator.validateCost(strCost);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
