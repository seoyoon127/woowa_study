package racingcar.utils;

public class TestAlwaysMove implements MoveStrategy{
    @Override
    public boolean canMove() {
        return true;
    }
}
