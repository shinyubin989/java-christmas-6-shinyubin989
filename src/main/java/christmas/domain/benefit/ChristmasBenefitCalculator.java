package christmas.domain.benefit;

import christmas.domain.Constants;
import christmas.domain.Order;
import christmas.domain.VisitDate;

public final class ChristmasBenefitCalculator implements BenefitCalculator{
    @Override
    public int calculate(Order order, VisitDate date) {
        int leftDays = date.daysLeftUntilChristmas();
        if (leftDays >= 0) {
            return Constants.BENEFIT_START_PRICE.getValue()
                    + Constants.DAILY_INCREASE_PRICE.getValue()
                    * (Constants.CHRISTMAS_DATE.getValue() - leftDays);
        }
        return 0;
    }
}
