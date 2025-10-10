package lotto.domain.enums;

public enum LottoRank {
    // 순서: 일치 개수 (win), 보너스 매치 (bonus), 상금 (prize)
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000),
    NONE(0, 0, 0);

    private final int matchCount;
    private final int matchBonus;
    private final long prize;

    LottoRank(int matchCount, int matchBonus, long prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static LottoRank valueOf(int matchCount, int matchBonus){
        if (matchCount == 6){
            return FIRST;
        }
        else if (matchCount == 5){
            if (matchBonus == 1){
                return SECOND;
            } return THIRD;
        }
        else if (matchCount == 4){
            return FOURTH;
        }
        else if (matchCount == 3){
            return FIFTH;
        }
        else{
            return NONE;
        }
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMatchBonus() {
        return matchBonus;
    }

    public long getPrize() {
        return prize;
    }
}
