package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.enums.LottoRank;

import java.util.List;

public class OutputView {
    static String COUNT_OUTPUT_MSG = "개를 구매했습니다.";
    static String RESULT_STATS_MSG = "당첨 통계\n---";
    static String PROFIT_RANGE_MSG = "총 수익률은 %s%%입니다.";

    public void output_count(Integer cnt){
        System.out.println(cnt + COUNT_OUTPUT_MSG);
    }

    public void output_lottoList(List<Lotto> lottoList){
        for (Lotto lotto : lottoList){
            System.out.println(lotto.getNumbers());
        }
    }

    public void output_result(Result result, Integer cost){
        System.out.println(RESULT_STATS_MSG);
        List<LottoRank> displayRanks = List.of(
                LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST
        );
        for (LottoRank rank : displayRanks){
            System.out.println(rank.getMessage() + result.getRankCounts().get(rank) + "개");
        }
        System.out.println(String.format(PROFIT_RANGE_MSG, result.calculateProfitRate(cost)));
    }
}
