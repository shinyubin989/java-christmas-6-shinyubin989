package christmas.domain.benefit;

import christmas.domain.Constants;
import christmas.domain.Order;
import christmas.domain.VisitDate;

final class SpecialBenefitCalculator implements BenefitCalculator{
    @Override
    public int calculate(Order order, VisitDate date) {
        if(date.isSpecificBenefitDay()) return Constants.SPECIAL_DAY_BENEFIT_PRICE.getValue();
        return 0;
    }
}
