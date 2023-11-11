package christmas.domain;

final class Giveaway {

    private GiveawayMenus giveaway = GiveawayMenus.NONE;

    Giveaway(int priceBeforeBenefit) {
        if (Constraint.PRICE_CORRESPONDING_TO_GIVEAWAY.getValue() <= priceBeforeBenefit) {
            giveaway = GiveawayMenus.CHAMPAGNE;
        }
    }

    int getGiveawayBenefitPrice() {
        return giveaway.meal.getPrice();
    }

    @Override
    public String toString() {
        return giveaway.meal + " " + giveaway.num;
    }

    enum GiveawayMenus {
        CHAMPAGNE(Meal.CHAMPAGNE, 1),
        NONE(null, 0),
        ;
        private final Meal meal;
        private final int num;

        GiveawayMenus(Meal meal, int num) {
            this.meal = meal;
            this.num = num;
        }
    }
}
