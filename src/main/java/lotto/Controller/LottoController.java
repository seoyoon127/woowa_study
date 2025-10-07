package lotto.Controller;

import lotto.Domain.LottoList;
import lotto.Domain.Result;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        Integer cost = inputView.input_cost();
        outputView.print_cnt(cost);

        LottoList lottoList = LottoList.of (cost/1000);
        outputView.print_lottoList(lottoList);

        List<Integer> winNums = inputView.input_lottoList();
        Integer bonus = inputView.input_bonusNum();

        Result result = Result.of(lottoList.getLottoList(), winNums, bonus);
        outputView.print_result(result);
    }
}
