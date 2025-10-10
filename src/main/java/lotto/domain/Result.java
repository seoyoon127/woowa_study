package lotto.domain;

import lotto.domain.enums.LottoRank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<LottoRank, Integer> rankCounts;

    public Result(){
        this.rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            this.rankCounts.put(rank, 0);
        }
    }

    public static Result of (List<Lotto> lottoList, List<Integer> winNums, Integer bonusNum){
        Result result = new Result();
        for (Lotto lotto: lottoList){
            int matchCount = lotto.compareWinNums(winNums);
            int matchBonus = lotto.compareBonusNum(bonusNum);
            LottoRank rank = LottoRank.valueOf(matchCount, matchBonus);
            result.increaseCount(rank);
        }
        return result;
    }

    private void increaseCount(LottoRank rank){
        if (rank != LottoRank.NONE){
            this.rankCounts.put(rank, this.rankCounts.get(rank) + 1);
        }
    }

    public String calculateProfitRate(int cost){
        long totalPrize = 0;
        for (Map.Entry<LottoRank, Integer> entry : rankCounts.entrySet()){
            LottoRank rank = entry.getKey();
            int count = entry.getValue();

            totalPrize += rank.getPrize() * count;
        }
        return String.format("%.1f", (double) totalPrize / cost * 100);
    }
}