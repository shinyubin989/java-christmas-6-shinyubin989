package christmas.domain.benefit;

import christmas.domain.Order;
import christmas.domain.VisitDate;
import christmas.dto.OrderDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeekendBenefitCalculatorTest {

    @Test
    void 주말인경우_메인메뉴의_할인_금액을_반환한다() {
        Order order = new Order(List.of(new OrderDto("크리스마스파스타", 2), new OrderDto("아이스크림", 2)));
        VisitDate visitDate = new VisitDate(29);

        int actual = new WeekendBenefitCalculator().calculate(order, visitDate);

        assertEquals(4046, actual);
    }

    @Test
    void 주말이_아닌경우_할인_금액을_반환한다() {
        Order order = new Order(List.of(new OrderDto("크리스마스파스타", 2), new OrderDto("아이스크림", 2)));
        VisitDate visitDate = new VisitDate(28);

        int actual = new WeekendBenefitCalculator().calculate(order, visitDate);

        assertEquals(0, actual);
    }

}