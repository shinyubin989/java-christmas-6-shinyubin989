package christmas.domain.benefit;

import christmas.domain.Order;
import christmas.domain.VisitDate;
import christmas.dto.OrderDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeekdayBenefitCalculatorTest {

    @Test
    void 평일인경우_할인_금액을_반환한다() {
        Order order = new Order(List.of(new OrderDto("양송이수프", 2), new OrderDto("아이스크림", 2)));
        VisitDate visitDate = new VisitDate(28);

        int actual = new WeekdayBenefitCalculator().calculate(order, visitDate);

        assertEquals(4046, actual);
    }

}