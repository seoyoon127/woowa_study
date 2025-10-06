package lotto.View;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

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

}