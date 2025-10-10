package lotto.domain;

import lotto.utils.RandomLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static LottoList of (Integer number) {
        List<Lotto> list = new ArrayList<Lotto>();
        for (int i=0; i<number; i++){
            list.add(RandomLotto.getLotto());
        }
        return new LottoList(list);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
