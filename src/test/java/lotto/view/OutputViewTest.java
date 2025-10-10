package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    private OutputView ov;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        ov = new OutputView();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }


    @DisplayName("개수 출력 테스트")
    @Test
    void print_cnt(){
        ov.output_count(3);
        String expected = "3개를 구매했습니다." + System.lineSeparator();
        assertThat(outputStreamCaptor.toString()).isEqualTo(expected);
    }

    @DisplayName("로또 리스트 출력 테스트")
    @Test
    void print_lottoList(){
        LottoList lottoList = new LottoList(
                List.of( new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                        new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                        new Lotto(List.of(7, 11, 16, 35, 36, 44)))
        );
        ov.output_lottoList(lottoList.getLottoList());
        String expected = "[8, 21, 23, 41, 42, 43]" + System.lineSeparator() +
                "[3, 5, 11, 16, 32, 38]" + System.lineSeparator() +"[7, 11, 16, 35, 36, 44]" + System.lineSeparator();
        assertThat(outputStreamCaptor.toString()).isEqualTo(expected);
    }
}