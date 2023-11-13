package christmas.domain.benefit;

import christmas.domain.Order;
import christmas.domain.VisitDate;

@FunctionalInterface
public interface BenefitCalculator {
    int calculate(Order order, VisitDate date);
}
