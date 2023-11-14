package christmas.domain;

import christmas.dto.OrderDto;
import christmas.io.InputView;
import christmas.io.OutputView;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest {

    @Test
    void 날짜_입력값을_받아와서_객체로_반환한다() {
        OrderController orderController = new OrderController(new InputView(() -> "3"), new OutputView());
        VisitDate date = orderController.receiveDate();
        assertEquals(new VisitDate(3), date);
    }

    @Test
    void 주문메뉴_입력값을_받아와서_객체로_반환한다() {
        OrderController orderController = new OrderController(new InputView(() -> "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"), new OutputView());

        Order expected = new Order(List.of(new OrderDto("티본스테이크", 1), new OrderDto("바비큐립", 1), new OrderDto("초코케이크", 2), new OrderDto("제로콜라", 1)));

        assertEquals(expected, orderController.receiveOrder());
    }

}