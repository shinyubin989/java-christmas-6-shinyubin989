package christmas.domain.benefit;

import christmas.domain.Constants;
import christmas.domain.Order;
import christmas.domain.VisitDate;

import java.util.EnumMap;
import java.util.Map;

public enum Benefits {

    CHRISTMAS_D_DAY("크리스마스 디데이 할인", new ChristmasBenefitCalculator()),
    WEEKDAY("평일 할인", new WeekdayBenefitCalculator()),
    WEEKEND("주말 할인", new WeekendBenefitCalculator()),
    SPECIAL("특별 할인", new SpecialBenefitCalculator()),
    GIVEAWAY("증정 이벤트", new GiveawayBenefitCalculator()),
    ;

    private final String name;
    private final BenefitCalculator benefitCalculator;

    Benefits(String name, BenefitCalculator benefitCalculator) {
        this.name = name;
        this.benefitCalculator = benefitCalculator;
    }

    public static Map<Benefits, Integer> allBenefits(Order order, VisitDate date) {
        if (order.sumOfAllOrders() < Constants.MINIMUM_BENEFIT_PRICE.getValue()) {
            return zeroAllBenefits();
        }
        return Map.ofEntries(
                Map.entry(CHRISTMAS_D_DAY, CHRISTMAS_D_DAY.benefitCalculator.calculate(order, date)),
                Map.entry(WEEKDAY, WEEKDAY.benefitCalculator.calculate(order, date)),
                Map.entry(WEEKEND, WEEKEND.benefitCalculator.calculate(order, date)),
                Map.entry(SPECIAL, SPECIAL.benefitCalculator.calculate(order, date)),
                Map.entry(GIVEAWAY, GIVEAWAY.benefitCalculator.calculate(order, date))
        );
    }

    public static Map<Benefits, Integer> realBenefits(Order order, VisitDate date) {
        if (order.sumOfAllOrders() < Constants.MINIMUM_BENEFIT_PRICE.getValue()) {
            Map<Benefits, Integer> realBenefits = new EnumMap<>(zeroAllBenefits());
            realBenefits.remove(GIVEAWAY);
            return realBenefits;
        }
        Map<Benefits, Integer> realBenefits = new EnumMap<>(allBenefits(order, date));
        realBenefits.remove(GIVEAWAY);
        return realBenefits;
    }

    private static Map<Benefits, Integer> zeroAllBenefits() {
        return Map.ofEntries(
                Map.entry(CHRISTMAS_D_DAY, 0),
                Map.entry(WEEKDAY, 0),
                Map.entry(WEEKEND, 0),
                Map.entry(SPECIAL, 0),
                Map.entry(GIVEAWAY, 0)
        );
    }

    public String getName() {
        return name;
    }
}
