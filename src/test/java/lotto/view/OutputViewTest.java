package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.Result;
import lotto.domain.enums.LottoRank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

    private static String getExpectedOutput(String... lines) {
        return String.join(System.lineSeparator(), lines) + System.lineSeparator();
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

    @DisplayName("당첨 통계 출력 테스트")
    @Test
    void print_stats(){
        Result result = new Result();
        ov.output_result(result);
        String expectedStatsLines = getExpectedOutput(
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개"
        );

        String expected = OutputView.RESULT_STATS_MSG + System.lineSeparator() + expectedStatsLines;
        assertThat(outputStreamCaptor.toString()).isEqualTo(expected);
    }
}