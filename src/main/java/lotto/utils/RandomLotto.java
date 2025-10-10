package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class RandomLotto {
    public static Lotto getLotto(){
       return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
