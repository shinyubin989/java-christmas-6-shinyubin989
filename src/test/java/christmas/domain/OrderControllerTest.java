package christmas.domain;

import christmas.io.InputView;
import christmas.io.OutputView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest {

    @Test
    void 날짜_입력값을_받아와서_객체로_반환한다() {
        OrderController orderController = new OrderController(new InputView(() -> "3"), new OutputView());
        VisitDate date = orderController.receiveDate();
        assertEquals(new VisitDate(3), date);
    }

}