package Utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.Lotto;

import java.util.Collections;
import java.util.List;

public class RandomLotto {
    public static Lotto getLottoNums(){
        List<Integer> lottoList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoList);
        return new Lotto(lottoList);
    }
}
