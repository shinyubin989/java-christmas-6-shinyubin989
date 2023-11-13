package christmas.domain;

final class PosMachine {

    private final Calculator calculator;

    public PosMachine(Calculator calculator) {
        this.calculator = calculator;
    }

    Receipt printReceipt(VisitDate date, Order order) {
        int priceBeforeBenefit = calculator.calculatePriceBeforeBenefit(order);
        return new Receipt(
                order,
                priceBeforeBenefit,
                new Giveaway(priceBeforeBenefit),
                calculator.calculateChristmasDDayBenefit(date),
                calculator.calculateWeekdayBenefit(order, date),
                calculator.calculateWeekendBenefit(order, date),
                calculator.calculateSpecialBenefit(order, date),
                calculator.calculateGiveawayBenefit(order),
                calculator.calculateAllMaxBenefit(order, date),
                calculator.calculatePriceAfterBenefit(order, date),
                calculator.calculateBadge(calculator.calculateAllMaxBenefit(order, date))
        );
    }
}
