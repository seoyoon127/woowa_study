package baseball.controller;

import baseball.domain.ComputerNum;
import baseball.domain.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private InputView inputView;
    private OutputView outputView;
    private Integer replayNum;

    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        replayNum = 1;
    }

    public void run(){
        outputView.print_start();
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
        Result result = new Result();
        for (int i=0; i<3; i++){
            int index = computerNum.getIndexOfNum(list.get(i));
            setResult(result, index, i);
        }
        Integer strike = result.getStrike();
        Integer ball = result.getBall();
        outputView.print_result(strike, ball);
        if (strike == 3 && ball == 0){
            outputView.print_three_strike();
            replay();
        }
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
