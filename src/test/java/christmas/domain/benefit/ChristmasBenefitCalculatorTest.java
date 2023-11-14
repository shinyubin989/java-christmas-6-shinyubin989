package christmas.domain.benefit;

import christmas.domain.Order;
import christmas.domain.VisitDate;
import christmas.dto.OrderDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasBenefitCalculatorTest {

    @Test
    void 크리스마스_할인_혜택_적용_날짜인경우_할인_금액을_반환한다() {
        Order order = new Order(List.of(new OrderDto("양송이수프", 2)));
        VisitDate visitDate = new VisitDate(25);

        int actual = new ChristmasBenefitCalculator().calculate(order, visitDate);

        assertEquals(3400, actual);
    }

    @Test
    void 크리스마스_할인_혜택_적용_날짜가_아닌경우_할인_금액을_반환한다() {
        Order order = new Order(List.of(new OrderDto("양송이수프", 2)));
        VisitDate visitDate = new VisitDate(26);

        int actual = new ChristmasBenefitCalculator().calculate(order, visitDate);

        assertEquals(0, actual);
    }

}