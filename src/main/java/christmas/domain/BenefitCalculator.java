package christmas.domain;

final class BenefitCalculator {

    int calculatePriceBeforeBenefit(Order order) {
        return order.getPriceSum();
    }

    int calculateChristmasDDayBenefit(VisitDate date) {
        int leftDays = date.daysLeftUntilChristmas();
        if (leftDays >= 0) {
            return Constant.BENEFIT_START_PRICE.price
                    + Constant.DAILY_INCREASE_PRICE.price
                    * (Constraint.CHRISTMAS_DATE.getValue() - leftDays);
        }
        return 0;
    }

    int calculateWeekdayBenefit(Order order, VisitDate date) {
        if (!date.isWeekend()) {
            return order.countDessertMenuNum() * Constant.WEEKDAY_BENEFIT_PRICE.price;
        }
        return 0;
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
