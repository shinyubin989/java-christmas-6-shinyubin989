package christmas.domain;

import christmas.dto.OrderDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void 주문에_중복이_있을경우_예외를_반환한다() {
        assertThatThrownBy(() -> new Order(List.of(new OrderDto("양송이수프", 1), new OrderDto("양송이수프", 1))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void 주문갯수가_20개를_초과할경우_예외를_반환한다() {
        assertThatThrownBy(() -> new Order(List.of(new OrderDto("양송이수프", 21))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void 주문에_오직_음료만_있을경우_예외를_반환한다() {
        assertThatThrownBy(() -> new Order(List.of(new OrderDto("제로콜라", 1), new OrderDto("샴페인",1), new OrderDto("레드와인", 1))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void 정상적인_주문의_경우_예외를_반환하지_않는다() {
        assertDoesNotThrow(() -> new Order(List.of(new OrderDto("제로콜라", 5), new OrderDto("양송이수프", 10), new OrderDto("초코케이크", 5))));
    }

    @Test
    void 총주문_금액을_계산한다() {
        Order order = new Order(List.of(new OrderDto("제로콜라", 5), new OrderDto("양송이수프", 10), new OrderDto("초코케이크", 5)));

        int expected = 5 * Meal.ZERO_COLA.getPrice() + 10 * Meal.MUSHROOM_SOUP.getPrice() + 5 * Meal.CHOCOLATE_CAKE.getPrice();

        assertEquals(expected, order.sumOfAllOrders());
    }

    @Test
    void 디저트_메뉴의_갯수를_센다() {
        Order order = new Order(List.of(new OrderDto("제로콜라", 5), new OrderDto("양송이수프", 10), new OrderDto("초코케이크", 5)));

        int expected = 5;

        assertEquals(expected, order.countDessertMenuNum());
    }

    @Test
    void 메인_메뉴의_갯수를_센다() {
        Order order = new Order(List.of(new OrderDto("제로콜라", 5), new OrderDto("크리스마스파스타", 10), new OrderDto("초코케이크", 5)));

        int expected = 10;

        assertEquals(expected, order.countMainMenuNum());
    }
}