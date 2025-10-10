package lotto.domain.enums;

public enum LottoRank {
    // 순서: 일치 개수 (win), 보너스 매치 (bonus), 상금 (prize), 문구(message)
    FIRST(6, 0, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 1, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 0, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 0, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, 0, 5_000, "3개 일치 (5,000원) - "),
    NONE(0, 0, 0, "");

    private final int matchCount;
    private final int matchBonus;
    private final long prize;
    private final String message;

    LottoRank(int matchCount, int matchBonus, long prize, String message) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
        this.message = message;
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

    public String getMessage() {return message;}
}
