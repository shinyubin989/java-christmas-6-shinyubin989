package christmas.domain;

import christmas.domain.benefit.Benefits;

import java.util.Map;

record Receipt(Order orderMenus, int priceBeforeBenefit,
               Giveaway giveaway, Map<Benefits, Integer> benefits,
               int priceAfterBenefit, String badge
) {
}
