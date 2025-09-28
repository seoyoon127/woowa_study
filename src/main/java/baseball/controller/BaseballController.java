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
        Result result = Result.of(computerNum, list);

        outputView.print_result(result.getStrike(), result.getBall());
        if (result.getStrike() == LENGTH){
            outputView.print_three_strike();
            isPlaying = false;
        }
    }

    public boolean replay(){
        return inputView.input_endNum() == GAME_RESTART;
    }
}
