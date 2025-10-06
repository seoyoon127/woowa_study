package lotto.View;

import Utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class InputView {
    static String COST_INPUT_MSG = "구입금액을 입력해 주세요.";
    static String LOTTO_NUMBER_MSG = "당첨 번호를 입력해 주세요.";
    static String BONUS_NUMBER_MSG = "보너스 번호를 입력해 주세요.";

    public Integer input_cost(){
        while(true){
            try{
                System.out.println(COST_INPUT_MSG);
                String strCost = Console.readLine();
                return InputValidator.validateCost(strCost);
            } catch (NumberFormatException e){
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> input_lottoList(){
        while(true){
            try{
                System.out.println(LOTTO_NUMBER_MSG);
                String strLotto = Console.readLine();
                return InputValidator.validateLottoList(strLotto);
            } catch (NumberFormatException e){
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public Integer input_bonusNum(){
        while(true){
            try{
                System.out.println(BONUS_NUMBER_MSG);
                String strBonus = Console.readLine();
                return InputValidator.validateBonusNum(strBonus);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
