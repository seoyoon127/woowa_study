package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.Result;
import lotto.view.InputView;

public class LottoController {
    InputView iv;

    public void run(){
        Integer cost = iv.input_cost();
        LottoList lottoList = LottoList.of(cost / 1000);
        //로또번호 리스트 출력

        Lotto winNums = iv.input_winNums();
        Integer bonusNum = iv.input_bonusNum();

        Result result = Result.of(lottoList.getLottoList(), winNums.getNumbers(), bonusNum);
        //당첨 통계 출력
    }
}
