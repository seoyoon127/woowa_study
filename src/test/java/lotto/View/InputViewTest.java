package lotto.View;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InputViewTest {
    private final InputStream standardIn = System.in;
    private InputView iv;

    @BeforeEach
    void setup(){
        iv = new InputView();
    }

    // 테스트가 끝난 후 원래의 System.in으로 복원
    @AfterEach
    void tearDown() {
        System.setIn(standardIn);
    }

    private void setInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @Test
    @DisplayName("금액 입력 성공")
    void test_input_cost(){
        setInput("2000");
        Integer cost = iv.input_cost();
        assertThat(cost).isEqualTo(2000);
    }

    @Test
    @DisplayName("금액 입력 실패 시 재시작")
    void test_input_cost_retry(){
        String invalidInput1 = "1500\n";
        String invalidInput2 = "abc\n";
        String validInput = "3000\n";

        String combinedInput = invalidInput1 + invalidInput2 + validInput;
        setInput(combinedInput);

        Integer cost = iv.input_cost();
        assertThat(cost).isEqualTo(3000);
    }

    @Test
    @DisplayName("당첨번호 입력 성공")
    void test_input_lottoList(){
        setInput("1,2,3,4,5,6");
        List<Integer> lottoList = iv.input_lottoList();
        assertThat(lottoList).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("당첨번호 입력 실패 시 재시작")
    void test_input_lottoList_retry(){
        String invalidInput1 = "1,2,3\n";
        String invalidInput2 = "abc,def,g,h,i,j\n";
        String invalidInput3 = "46,0,1,2,3,4\n";
        String validInput = "1,2,3,4,5,6\n";

        String combinedInput = invalidInput1 + invalidInput2 + invalidInput3 + validInput;
        setInput(combinedInput);

        List<Integer> lottoList = iv.input_lottoList();
        assertThat(lottoList).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("보너스번호 입력 성공")
    void test_input_bonusNum(){
        setInput("3");
        Integer bonusNum = iv.input_bonusNum();
        assertThat(bonusNum).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스번호 입력 실패 시 재시작")
    void test_input_bonusNum_retry(){
        String invalidInput1 = "s\n";
        String invalidInput2 = "48\n";
        String validInput = "3";

        String combinedInput = invalidInput1 + invalidInput2 + validInput;
        setInput(combinedInput);

        Integer bonusNum = iv.input_bonusNum();
        assertThat(bonusNum).isEqualTo(3);
    }
}