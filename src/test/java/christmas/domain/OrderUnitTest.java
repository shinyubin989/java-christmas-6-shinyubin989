package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class OrderUnitTest {

    @Test
    void 단건_주문갯수가_1보다_작을_경우_예외를_발생시킨다() {
        assertThatThrownBy(() -> new OrderUnit("양송이수프", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void 정상적인_단건_주문의_경우_예외를_발생시키지_않는다() {
        assertDoesNotThrow(() -> new OrderUnit("양송이수프", 1));
    }

    @Test
    void 디저트_메뉴의_경우_true를_반환한다() {
        OrderUnit orderUnit = new OrderUnit("초코케이크", 1);

        assertTrue(orderUnit.isDessertMenu());
    }

    @Test
    void 디저트_메뉴가_아닌_경우_false를_반환한다() {
        OrderUnit orderUnit = new OrderUnit("바비큐립", 1);

        assertFalse(orderUnit.isDessertMenu());
    }

    @Test
    void 메인_메뉴가_아닌_경우_false를_반환한다() {
        OrderUnit orderUnit = new OrderUnit("초코케이크", 1);

        assertFalse(orderUnit.isMainMenu());
    }

}