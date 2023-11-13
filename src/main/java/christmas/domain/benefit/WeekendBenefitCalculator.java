package christmas.domain.benefit;

import christmas.domain.Constants;
import christmas.domain.Order;
import christmas.domain.VisitDate;

final class WeekendBenefitCalculator implements BenefitCalculator{
    @Override
    public int calculate(Order order, VisitDate date) {
        if (date.isWeekend()) {
            return order.countMainMenuNum() * Constants.WEEKEND_BENEFIT_PRICE.getValue();
        }
        return 0;
    }
}
