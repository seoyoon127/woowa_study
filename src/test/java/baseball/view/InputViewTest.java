package baseball.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    String isNum = "123";
    String isNotNum = "abs";
    String isNumOver = "1234";

    @Test
    void test_validateIsNumber_success(){
        assertThat(InputView.Validation.isNumber(isNum)).isEqualTo(true);
    }

    @Test
    void test_validateIsNumber_error(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.Validation.validateIsNumber(isNotNum);
        });
    }

    @Test
    void test_validateIsLength3_success(){
        assertThat(InputView.Validation.isLength3(isNum)).isEqualTo(true);
    }

    @Test
    void test_validateIsLength3_error(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.Validation.validateLength3(isNumOver);
        });
    }

    @Test
    void test_saveAsList(){
        List<Integer> list = InputView.Validation.saveAsList(isNum);
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(2);
        assertThat(list.get(2)).isEqualTo(3);
    }

}