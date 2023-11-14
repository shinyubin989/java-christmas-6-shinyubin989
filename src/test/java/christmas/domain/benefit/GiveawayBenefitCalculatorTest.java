package christmas.domain.benefit;

import christmas.domain.Meal;
import christmas.domain.Order;
import christmas.domain.VisitDate;
import christmas.dto.OrderDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GiveawayBenefitCalculatorTest {

    @Test
    void 증정이벤트_혜택_적용_대상인_경우_할인_금액을_반환한다() {
        Order order = new Order(List.of(new OrderDto("양송이수프", 20)));
        VisitDate visitDate = new VisitDate(31);

        int actual = new GiveawayBenefitCalculator().calculate(order, visitDate);

        assertEquals(Meal.CHAMPAGNE.getPrice(), actual);
    }

}