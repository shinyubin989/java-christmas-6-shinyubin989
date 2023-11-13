package christmas.domain;

@FunctionalInterface
public interface BenefitCalculator {
    int calculate(Order order, VisitDate date);
}
