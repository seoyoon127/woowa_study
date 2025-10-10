package lotto.view;

import lotto.domain.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("구매금액 오류 발생 시 재시작")
    @Test
    void test_costError(){
        String input1 = "1200\n";
        String input2 = "string\n";
        String input3 = "10000";
        String inputs = input1 + input2 + input3;

        setInput(inputs);
        Integer cost = iv.input_cost();
        assertThat(cost).isEqualTo(10000);
    }

    @DisplayName("당첨번호 오류 발생 시 재시작")
    @Test
    void test_winNumsError(){
        String input1 = "1,2,3,4\n";
        String input2 = "a,b,c,d,e,f\n";
        String input3 = "0,1,2,3,4,5\n";
        String input4 = "1,2,3,4,5,6";
        String inputs = input1 + input2 + input3 + input4;

        setInput(inputs);
        Lotto winLotto = iv.input_winNums();
        assertThat(winLotto.getNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @DisplayName("보너스 번호 오류 발생 시 재시작")
    @Test
    void test_bonusNumError(){
        String input1 = "a\n";
        String input2 = "47\n";
        String input3 = "4\n";
        String inputs = input1 + input2 + input3;

        setInput(inputs);
        Integer bonusNum = iv.input_bonusNum();
        assertThat(bonusNum).isEqualTo(4);
    }
}