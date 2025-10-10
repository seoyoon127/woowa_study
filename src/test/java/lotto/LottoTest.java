package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 범위가 1~45가 아닐 시 예외가 발생한다.")
    @Test
    void createLottoByOutRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 정렬 확인")
    @Test
    void lottoNumsSorted() {
        Lotto lotto = new Lotto(List.of(6,5,4,3,2,1));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @DisplayName("당첨 번호 개수 반환")
    @Test
    void lottoWinCount() {
        Lotto winNums = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto = new Lotto(List.of(1,3,5,7,9,11));
        assertThat(lotto.compareWinNums(winNums.getNumbers())).isEqualTo(3);
    }

    @DisplayName("보너스 번호 일치 반환")
    @Test
    void lottoBonusCount() {
        Lotto lotto = new Lotto(List.of(1,3,5,7,9,11));
        assertThat(lotto.compareBonusNum(11)).isEqualTo(1);
        assertThat(lotto.compareBonusNum(12)).isEqualTo(0);
    }
}