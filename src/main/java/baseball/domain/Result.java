package baseball.domain;

public class Result {
    private Integer strike;
    private Integer ball;

    public Result() {
        this.strike = 0;
        this.ball = 0;
    }

    public void plusStrike(){
        strike += 1;
    }

    public void plusBall(){
        ball += 1;
    }

    public Integer getStrike(){
        return strike;
    }

    public Integer getBall(){
        return ball;
    }
}
