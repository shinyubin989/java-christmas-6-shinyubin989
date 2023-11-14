package christmas.domain;

import christmas.domain.benefit.Benefits;

import java.util.Map;

public final class PosMachine {

    public Receipt printReceipt(VisitDate date, Order order) {
        int totalPrice = order.sumOfAllOrders();
        Map<Benefits, Integer> allBenefits = Benefits.allBenefits(order, date);
        Giveaway giveaway = new Giveaway(totalPrice);

        int priceAllBenefits = sumOfBenefits(allBenefits);
        int priceAfterBenefits = totalPrice - sumOfBenefits(Benefits.realBenefits(order, date));

        return new Receipt(order, totalPrice, giveaway, allBenefits, priceAfterBenefits, chooseBadge(priceAllBenefits));
    }

    private int sumOfBenefits(Map<Benefits, Integer> benefits) {
        return benefits.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private String chooseBadge(int benefitPrice) {
        return Badge.findBadgeByBenefitPrice(benefitPrice);
    }
}
