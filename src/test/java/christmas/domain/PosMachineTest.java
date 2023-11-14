package christmas.domain;

import christmas.domain.benefit.Benefits;
import christmas.dto.OrderDto;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PosMachineTest {

    @Test
    void 날짜와_주문에_해당하는_영수증을_반환한다() {
        VisitDate date = new VisitDate(3);
        Order order = new Order(List.of(new OrderDto("티본스테이크", 1), new OrderDto("바비큐립", 1), new OrderDto("초코케이크", 2), new OrderDto("제로콜라", 1)));
        PosMachine posMachine = new PosMachine();
        Receipt expectedBenefits = new Receipt(
                order,
                order.sumOfAllOrders(),
                new Giveaway(142_000),
                new EnumMap<>(Benefits.class) {{
                    put(Benefits.CHRISTMAS_D_DAY, 1200);
                    put(Benefits.WEEKDAY, 4046);
                    put(Benefits.WEEKEND, 0);
                    put(Benefits.SPECIAL, 1000);
                    put(Benefits.GIVEAWAY, 25000);
                }},
                135754,
                "산타"
        );

        assertEquals(expectedBenefits, posMachine.printReceipt(date, order));
    }

}