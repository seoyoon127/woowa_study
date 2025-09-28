package baseball.controller;

import baseball.domain.ComputerNum;
import baseball.domain.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private InputView inputView;
    private OutputView outputView;
    private boolean isPlaying;

    private static final int LENGTH = 3;
    private static final int GAME_RESTART = 1;


    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        isPlaying = true;
    }

    public void run(){
        outputView.print_start();
        do{
            start();
        } while(replay());
    }

    public void start(){
        ComputerNum computerNum = new ComputerNum();
        computerNum.setComputerNum();
        isPlaying = true;
        while (isPlaying){
            compare(computerNum);
        }
    }
    public void compare(ComputerNum computerNum){
        List<Integer> list = inputView.input_numbers();
        Result result = calculateResult(computerNum, list);

        outputView.print_result(result.getStrike(), result.getBall());
        if (result.getStrike() == LENGTH){
            outputView.print_three_strike();
            isPlaying = false;
        }
    }

    public Result calculateResult(ComputerNum computerNum, List<Integer> list){
        Result result = new Result();
        for (int i=0; i<LENGTH; i++){
            int index = computerNum.getIndexOfNum(list.get(i));
            setResult(result, index, i);
        }
        return result;
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

    public boolean replay(){
        return inputView.input_endNum() == GAME_RESTART;
    }
}
