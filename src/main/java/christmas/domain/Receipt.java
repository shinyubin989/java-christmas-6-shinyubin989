package christmas.domain;

record Receipt(Order orderMenus, int priceBeforeBenefit,
               Giveaway giveaway, int christmasBenefit,
               int weekdayBenefit, int weekendBenefit,
               int specialBenefit, int giveawayBenefit,
               int allBenefitPrice, int priceAfterBenefit,
               String badge
) {
}
