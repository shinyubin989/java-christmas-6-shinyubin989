package christmas.domain;

final class BenefitCalculator {

    int calculatePriceBeforeBenefit(Order order) {
        return order.getPriceSum();
    }

    enum Constant{
        BENEFIT_START_PRICE(1000),
        DAILY_INCREASE_PRICE(100),
        WEEKDAY_BENEFIT_PRICE(2023),
        WEEKEND_BENEFIT_PRICE(2023),
        SPECIAL_DAY_BENEFIT_PRICE(1000),
        ;

        private final int price;

        Constant(int price) {
            this.price = price;
        }
    }
}
