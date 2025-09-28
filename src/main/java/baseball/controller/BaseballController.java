package baseball.controller;

import baseball.domain.ComputerNum;
import baseball.domain.Result;
import baseball.view.InputView;

import java.util.List;

public class BaseballController {
    private InputView inputView;
    private Integer replayNum;

    public BaseballController() {
        replayNum = 1;
    }

    public BaseballController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run(){
        inputView.print_start();
        start();
    }

    public void start(){
        ComputerNum computerNum = new ComputerNum();
        computerNum.setComputerNum();
        while (replayNum == 1){
            compare(computerNum);
        }
    }
    public void compare(ComputerNum computerNum){
        List<Integer> list = inputView.input_numbers();
        for (int i=0; i<3; i++){
            int index = computerNum.getIndexOfNum(list.get(i));
            Result result = new Result();
            setResult(result, index, i);
        }
        // OutputView(strikeNum, ballNum);

    }

    public void setResult(Result result, int index, int i){
        if (index != -1){
            if (index == i){
                result.plusStrike();
            }
            else{
                result.plusBall();
            }
        }
    }

    public void replay(){
        Integer endNum = inputView.input_endNum();
        if (endNum == 1){
            start();
        }
        else{
            replayNum = endNum;
        }
    }
}
