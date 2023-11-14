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
        Order order = new Order(List.of(new OrderDto("양송이수프", 2)));
        VisitDate visitDate = new VisitDate(date);

        Map<Benefits, Integer> benefits = Benefits.allBenefits(order, visitDate);

        assertEquals(expected, benefits.get(Benefits.CHRISTMAS_D_DAY));
    }

    @ParameterizedTest
    @CsvSource(value = {"3,14161", "7,14161", "19,14161", "31,14161"}, delimiter = ',')
    void 평일에_맞는_혜택을_반환한다(int date, int expected) {
        Order order = new Order(List.of(new OrderDto("양송이수프", 1), new OrderDto("초코케이크", 2), new OrderDto("아이스크림", 5)));
        VisitDate visitDate = new VisitDate(date);

        Map<Benefits, Integer> benefits = Benefits.allBenefits(order, visitDate);

        assertEquals(expected, benefits.get(Benefits.WEEKDAY));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,10115", "16,10115", "29,10115", "30,10115"}, delimiter = ',')
    void 주말에_맞는_혜택을_반환한다(int date, int expected) {
        Order order = new Order(List.of(new OrderDto("양송이수프", 10), new OrderDto("해산물파스타", 5), new OrderDto("초코케이크", 2), new OrderDto("아이스크림", 2)));
        VisitDate visitDate = new VisitDate(date);

        Map<Benefits, Integer> benefits = Benefits.allBenefits(order, visitDate);

        assertEquals(expected, benefits.get(Benefits.WEEKEND));
    }

    @ParameterizedTest
    @CsvSource(value = {"3,1000", "17,1000", "25,1000", "31,1000", "30,0"}, delimiter = ',')
    void 특별할인에_맞는_혜택을_반환한다(int date, int expected) {
        Order order = new Order(List.of(new OrderDto("양송이수프", 10)));
        VisitDate visitDate = new VisitDate(date);

        Map<Benefits, Integer> benefits = Benefits.allBenefits(order, visitDate);

        assertEquals(expected, benefits.get(Benefits.SPECIAL));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,25000", "31,25000"}, delimiter = ',')
    void 증정이벤트_대상인_금액의_경우_혜택을_반환한다(int date, int expected) {
        Order order = new Order(List.of(new OrderDto("티본스테이크", 2), new OrderDto("초코케이크", 1)));
        VisitDate visitDate = new VisitDate(date);

        Map<Benefits, Integer> benefits = Benefits.allBenefits(order, visitDate);

        assertEquals(expected, benefits.get(Benefits.GIVEAWAY));
    }

    @Test
    void 크리스마스_디데이_할인_대상_날짜가_아닌경우_혜택을_반환하지_않는다() {
        Order order = new Order(List.of(new OrderDto("티본스테이크", 2), new OrderDto("초코케이크", 1)));
        VisitDate visitDate = new VisitDate(26);

        Map<Benefits, Integer> benefits = Benefits.allBenefits(order, visitDate);

        assertEquals(0, benefits.get(Benefits.CHRISTMAS_D_DAY));
    }

    @Test
    void 평일_할인_대상_날짜가_아닌경우_혜택을_반환하지_않는다() {
        Order order = new Order(List.of(new OrderDto("초코케이크", 1)));
        VisitDate visitDate = new VisitDate(1);

        Map<Benefits, Integer> benefits = Benefits.allBenefits(order, visitDate);

        assertEquals(0, benefits.get(Benefits.WEEKDAY));
    }

    @Test
    void 주말_할인_대상_날짜가_아닌경우_혜택을_반환하지_않는다() {
        Order order = new Order(List.of(new OrderDto("티본스테이크", 1)));
        VisitDate visitDate = new VisitDate(3);

        Map<Benefits, Integer> benefits = Benefits.allBenefits(order, visitDate);

        assertEquals(0, benefits.get(Benefits.WEEKEND));
    }

    @Test
    void 특별_할인_대상_날짜가_아닌경우_혜택을_반환하지_않는다() {
        Order order = new Order(List.of(new OrderDto("티본스테이크", 1)));
        VisitDate visitDate = new VisitDate(26);

        Map<Benefits, Integer> benefits = Benefits.allBenefits(order, visitDate);

        assertEquals(0, benefits.get(Benefits.SPECIAL));
    }

    @Test
    void 증정이벤트_할인_대상_날짜가_아닌경우_혜택을_반환하지_않는다() {
        Order order = new Order(List.of(new OrderDto("티본스테이크", 1)));
        VisitDate visitDate = new VisitDate(3);

        Map<Benefits, Integer> benefits = Benefits.allBenefits(order, visitDate);

        assertEquals(0, benefits.get(Benefits.GIVEAWAY));
    }
}