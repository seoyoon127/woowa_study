package lotto.Controller;

import lotto.Domain.LottoList;
import lotto.Domain.Result;
import lotto.View.InputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run(){
        Integer cost = inputView.input_cost();
        print_cnt(cost);

        LottoList lottoList = LottoList.of (cost/1000);
        print_lottoList(lottoList);

        List<Integer> winNum = inputView.input_lottoList();
        Integer bonus = inputView.input_bonusNum();

        print_result(lottoList,winNum, bonus);
    }

    public void print_cnt(Integer cost){
        //구매 개수 출력

    }
    public void print_lottoList(LottoList lottoList){
        //로또 번호 출력
    }


    public void print_result(LottoList lottoList, List<Integer> winNums, Integer bonus){
        Result result = Result.of(lottoList.getLottoList(), winNums, bonus);
        //당첨 통계 출력
    }
}
