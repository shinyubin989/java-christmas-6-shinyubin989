package christmas.domain.benefit;

import christmas.domain.Order;
import christmas.domain.VisitDate;
import christmas.dto.OrderDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpecialBenefitCalculatorTest {

    @Test
    void 특별_할인_혜택_적용_날짜인경우_할인_금액을_반환한다() {
        Order order = new Order(List.of(new OrderDto("양송이수프", 2)));
        VisitDate visitDate = new VisitDate(25);

        int actual = new SpecialBenefitCalculator().calculate(order, visitDate);

        assertEquals(1000, actual);
    }
}