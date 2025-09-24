package racingcar.utils;

public class TestNeverMove implements MoveStrategy{
    @Override
    public boolean canMove() {
        return false;
    }
}
