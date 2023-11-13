package christmas.domain.benefit;

import christmas.domain.Order;
import christmas.domain.VisitDate;

@FunctionalInterface
interface BenefitCalculator {
    int calculate(Order order, VisitDate date);
}