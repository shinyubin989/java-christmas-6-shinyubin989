package christmas.domain.benefit;

import christmas.domain.Order;
import christmas.domain.VisitDate;

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

    static Map<Benefits, Integer> allBenefits(Order order, VisitDate date) {
        return Map.ofEntries(
                Map.entry(CHRISTMAS_D_DAY, CHRISTMAS_D_DAY.benefitCalculator.calculate(order, date)),
                Map.entry(WEEKDAY, WEEKDAY.benefitCalculator.calculate(order, date)),
                Map.entry(WEEKEND, WEEKEND.benefitCalculator.calculate(order, date)),
                Map.entry(SPECIAL, SPECIAL.benefitCalculator.calculate(order, date)),
                Map.entry(GIVEAWAY, GIVEAWAY.benefitCalculator.calculate(order, date))
        );
    }

    static Map<Benefits, Integer> realBenefits(Order order, VisitDate date) {
        return Map.ofEntries(
                Map.entry(CHRISTMAS_D_DAY, CHRISTMAS_D_DAY.benefitCalculator.calculate(order, date)),
                Map.entry(WEEKDAY, WEEKDAY.benefitCalculator.calculate(order, date)),
                Map.entry(WEEKEND, WEEKEND.benefitCalculator.calculate(order, date)),
                Map.entry(SPECIAL, SPECIAL.benefitCalculator.calculate(order, date))
        );
    }

    public String getName() {
        return name;
    }
}
