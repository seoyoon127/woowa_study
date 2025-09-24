package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    @Test
    void validCarNames_noDuplicate_success(){
        List<String> result = InputView.Validator.validateCarNames("A,B,C");
        assertEquals(3, result.size());
        assertTrue(result.contains("A"));
        assertTrue(result.contains("B"));
        assertTrue(result.contains("C"));
    }

    @Test
    void validateCarNames_isEmpty_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.Validator.validateCarNames("");
        });
    }

    @Test
    void validateCarNames_withDuplicate_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.Validator.validateCarNames("A,B,A");
        });
    }

    @Test
    void validateCarNames_withLengthExceed_throwsException(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.Validator.validateCarNames("ABCDEFG,A,B");
        });
    }

}