package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    static String COUNT_OUTPUT_MSG = "개를 구매했습니다.";

    public void output_count(Integer cnt){
        System.out.println(cnt + COUNT_OUTPUT_MSG);
    }

    public void output_lottoList(List<Lotto> lottoList){
        for (Lotto lotto : lottoList){
            System.out.println(lotto.getNumbers());
        }
    }
}
