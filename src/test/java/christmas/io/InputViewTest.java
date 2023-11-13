package christmas.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void 날짜를_받아온다() {
        InputView inputView = new InputView(() -> "3");
        int date = inputView.readDate();
        assertEquals(3, date);
    }

    @Test
    void 날짜_입력값이_숫자가_아닐경우_예외를_발생시킨다() {
        InputView inputView = new InputView(() -> "a");
        assertThatThrownBy(inputView::readDate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

}