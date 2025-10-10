package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView iv;
    private OutputView ov;

    public LottoController(InputView iv, OutputView ov) {
        this.iv = iv;
        this.ov = ov;
    }

    public void run(){
        Integer cost = iv.input_cost();
        LottoList lottoList = LottoList.of(cost / 1000);
        ov.output_count(cost/1000);
        ov.output_lottoList(lottoList.getLottoList());

        Lotto winNums = iv.input_winNums();
        Integer bonusNum = iv.input_bonusNum();

        Result result = Result.of(lottoList.getLottoList(), winNums.getNumbers(), bonusNum);
        ov.output_result(result, cost);
    }
}
