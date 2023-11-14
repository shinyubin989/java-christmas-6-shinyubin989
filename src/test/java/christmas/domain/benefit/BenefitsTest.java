package christmas.domain.benefit;

import christmas.domain.Order;
import christmas.domain.VisitDate;
import christmas.dto.OrderDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BenefitsTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1000", "10,1900", "24,3300", "25,3400"}, delimiter = ',')
    void 크리스마스_디데이에_맞는_혜택을_반환한다(int date, int expected) {
        Order order = new Order(List.of(new OrderDto("양송이수프", 1)));
        VisitDate visitDate = new VisitDate(date);

        Map<Benefits, Integer> benefits = Benefits.allBenefits(order, visitDate);

        assertEquals(expected, benefits.get(Benefits.CHRISTMAS_D_DAY));
    }

}