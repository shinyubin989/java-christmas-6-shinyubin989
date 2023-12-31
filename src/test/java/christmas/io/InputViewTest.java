package christmas.io;

import christmas.dto.OrderDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void 주문_메뉴를_받아온다() {
        List<OrderDto> expected = new ArrayList<>(List.of(new OrderDto("양송이수프", 1), new OrderDto("타파스", 1)));
        InputView inputView = new InputView(() -> "양송이수프-1,타파스-1");
        assertEquals(expected, inputView.readMenus());
    }

    @Test
    void 주문_메뉴가_비어있을_경우_예외를_발생시킨다() {
        InputView inputView = new InputView(() -> "");
        assertThatThrownBy(inputView::readMenus)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void 주문_갯수가_숫자가_아닐경우_예외를_발생시킨다() {
        InputView inputView = new InputView(() -> "양송이수프-a");
        assertThatThrownBy(inputView::readMenus)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void 메뉴가_콤마로_구분되지_않은경우_예외를_발생시킨다() {
        InputView inputView = new InputView(() -> "양송이수프-1 타파스-1");
        assertThatThrownBy(inputView::readMenus)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void 메뉴_갯수가_integer_범위를_초과할경우_예외를_발생시킨다() {
        InputView inputView = new InputView(() -> "양송이수프-2147483648");
        assertThatThrownBy(inputView::readMenus)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void 메뉴_갯수가_음수인경우_예외를_발생시킨다() {
        InputView inputView = new InputView(() -> "양송이수프--1");
        assertThatThrownBy(inputView::readMenus)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void 메뉴_입력값_앞에_콤마가_붙은경우_예외를_발생시킨다() {
        InputView inputView = new InputView(() -> ",양송이수프-1");
        assertThatThrownBy(inputView::readMenus)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void 메뉴_입력값_뒤에_콤마가_붙은경우_예외를_발생시킨다() {
        InputView inputView = new InputView(() -> "양송이수프-1,");
        assertThatThrownBy(inputView::readMenus)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void 메뉴_포맷이_적합하지_않은경우_예외를_발생시킨다() {
        InputView inputView = new InputView(() -> "양송이수프-1,타파스");
        assertThatThrownBy(inputView::readMenus)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}