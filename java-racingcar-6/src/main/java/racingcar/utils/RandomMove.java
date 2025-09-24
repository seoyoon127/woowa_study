package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMove implements MoveStrategy{
    @Override
    public boolean canMove(){
        return Randoms.pickNumberInRange(0,9)>=4;
    }
}
