package christmas.domain.benefit;

import christmas.domain.Constants;
import christmas.domain.Meal;
import christmas.domain.Order;
import christmas.domain.VisitDate;

public final class GiveawayBenefitCalculator implements BenefitCalculator{
    @Override
    public int calculate(Order order, VisitDate date) {
        if (Constants.PRICE_CORRESPONDING_TO_GIVEAWAY.getValue() <= order.getPriceSum()) {
            return Meal.CHAMPAGNE.getPrice();
        }
        return 0;
    }
}
