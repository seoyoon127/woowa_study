package baseball.domain;

import java.util.List;

public class Result {
    private Integer strike;
    private Integer ball;

    private Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Result of(ComputerNum computerNum, List<Integer> list){
        int strike = 0;
        int ball = 0;
        for (int i=0; i<3; i++){
            int index = computerNum.getIndexOfNum(list.get(i));
            if (index != -1){
                if (index == i){
                    strike += 1;
                }
                else{
                    ball += 1;
                }
            }
        }
        return new Result(strike, ball);
    }

    public Integer getStrike(){
        return strike;
    }

    public Integer getBall(){
        return ball;
    }
}
