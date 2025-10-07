package lotto.View;

import lotto.Domain.Lotto;
import lotto.Domain.LottoList;
import lotto.Domain.Result;

import java.util.List;

public class OutputView {
    static String CNT_MSG = "개를 구매했습니다.";
    static String RESULT_MSG = "당첨통계\n---\n";
    static List<String> RESULT_LIST_MSG = List.of("3개 일치 (5,000원) - ","4개 일치 (50,000원) - ",
            "5개 일치 (1,500,000원) - ", "5개 일치, 보너스 볼 일치 (30,000,000원) - ", "6개 일치 (2,000,000,000원) - ");
    static String PROFIT_MSG = "총 수익률은 %.1f%%입니다.";

    public void print_cnt(Integer cnt){
        System.out.println(cnt + CNT_MSG);
    }

    public void print_lottoList(LottoList lottoList){
        for (Lotto lotto : lottoList.getLottoList()){
            System.out.println(lotto.getLotto());
        }
    }

    public void print_result(Result result){
        System.out.println(RESULT_MSG);
        List<Integer> results = result.getResultList();
        for (int i=0; i<5; i++){
            System.out.println(RESULT_LIST_MSG.get(i) + results.get(i) + "개");
        }
    }
}
