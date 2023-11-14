package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class VisitDateTest {

    @Test
    void 일자를_32일_이상으로_입력하면_예외를_반환한다() {
        assertThatThrownBy(() -> new VisitDate(32))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    void 일자를_0일_이하로_입력하면_예외를_반환한다() {
        assertThatThrownBy(() -> new VisitDate(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    void 일자를_1에서_31_사이의_숫자로_입력하면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> new VisitDate(1));
        assertDoesNotThrow(() -> new VisitDate(15));
        assertDoesNotThrow(() -> new VisitDate(31));
    }

    @Test
    void 주말인경우_true를_반환한다() {
        assertTrue(() -> new VisitDate(1).isWeekend());
    }

}