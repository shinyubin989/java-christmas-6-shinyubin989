package christmas.domain;

final class Calculator {

    int calculatePriceBeforeBenefit(Order order) {
        return order.getPriceSum();
    }

    int calculateChristmasDDayBenefit(VisitDate date) {
        int leftDays = date.daysLeftUntilChristmas();
        if (leftDays >= 0) {
            return Constants.BENEFIT_START_PRICE.getValue()
                    + Constants.DAILY_INCREASE_PRICE.getValue()
                    * (Constants.CHRISTMAS_DATE.getValue() - leftDays);
        }
        return 0;
    }

    int calculateWeekdayBenefit(Order order, VisitDate date) {
        if (!date.isWeekend()) {
            return order.countDessertMenuNum() * Constants.WEEKDAY_BENEFIT_PRICE.getValue();
        }
        return 0;
    }

    int calculateWeekendBenefit(Order order, VisitDate date) {
        if (date.isWeekend()) {
            return order.countMainMenuNum() * Constants.WEEKEND_BENEFIT_PRICE.getValue();
        }
        return 0;
    }

    int calculateSpecialBenefit(Order order, VisitDate date) {
        if(date.isSpecificBenefitDay()) return Constants.SPECIAL_DAY_BENEFIT_PRICE.getValue();
        return 0;
    }

    int calculateGiveawayBenefit(Order order) {
        if (Constants.PRICE_CORRESPONDING_TO_GIVEAWAY.getValue() <= order.getPriceSum()) {
            return Meal.CHAMPAGNE.getPrice();
        }
        return 0;
    }

    int calculateAllMaxBenefit(Order order, VisitDate date) {
        return calculateChristmasDDayBenefit(date)
                + calculateWeekdayBenefit(order, date)
                + calculateWeekendBenefit(order, date)
                + calculateSpecialBenefit(order, date)
                + calculateGiveawayBenefit(order);
    }

    int calculatePriceAfterBenefit(Order order, VisitDate date) {
        return calculatePriceBeforeBenefit(order)
                - calculateAllMaxBenefit(order, date)
                + calculateGiveawayBenefit(order);
    }

    String calculateBadge(int benefitPrice) {
        return Badge.findBadgeByBenefitPrice(benefitPrice);
    }
}
