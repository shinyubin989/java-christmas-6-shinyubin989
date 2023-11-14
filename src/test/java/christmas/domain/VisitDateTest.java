package christmas.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    void 주중인경우_false를_반환한다() {
        assertFalse(() -> new VisitDate(3).isWeekend());
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void 특별_혜택_날인_경우_true를_반환한다(int date) {
        assertTrue(() -> new VisitDate(date).isSpecificBenefitDay());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 5, 6, 7, 8, 9, 11, 12, 13,
            14, 15, 16, 18, 19, 20, 21, 22, 23, 26, 27, 28, 29, 30})
    void 특별_혜택_날이_아닌_경우_false를_반환한다(int date) {
        assertFalse(() -> new VisitDate(date).isSpecificBenefitDay());
    }

    @Test
    void 크리스마스까지_남은_일수를_반환한다() {
        assertEquals(10, new VisitDate(15).daysLeftUntilChristmas());
    }
}