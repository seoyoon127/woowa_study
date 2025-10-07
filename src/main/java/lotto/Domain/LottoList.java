package lotto.Domain;

import Utils.RandomLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static LottoList of (Integer listNum){
        List<Lotto> list = new ArrayList<Lotto>();
        for (int i=0; i<listNum; i++){
            list.add(RandomLotto.getLottoNums());
        }
        return new LottoList(list);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

}
