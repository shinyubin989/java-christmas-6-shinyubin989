package christmas.domain;

import christmas.domain.benefit.Benefits;

import java.util.Map;

public record Receipt(Order order, int priceBeforeBenefit, Giveaway giveaway, Map<Benefits, Integer> benefits,
               int priceAfterBenefit, String badge
) {
}
