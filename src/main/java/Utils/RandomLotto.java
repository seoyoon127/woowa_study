package Utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.Lotto;

import java.util.List;

public class RandomLotto {
    public static Lotto getLottoNums(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
