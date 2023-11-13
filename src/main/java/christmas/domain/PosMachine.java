package christmas.domain;

import christmas.domain.benefit.Benefits;

import java.util.Map;

final class PosMachine {

    Receipt printReceipt(VisitDate date, Order order) {
        int totalPrice = order.sumOfAllOrders();
        Map<Benefits, Integer> allBenefits = Benefits.allBenefits(order, date);
        Giveaway giveaway = new Giveaway(totalPrice);
        int priceAfterBenefits = totalPrice - sumOfRealBenefits(order, date);

        return new Receipt(order, totalPrice, giveaway, allBenefits,
                priceAfterBenefits, chooseBadge(totalPrice));
    }

    private int sumOfRealBenefits(Order order, VisitDate date) {
        Map<Benefits, Integer> realBenefits = Benefits.realBenefits(order, date);
        return realBenefits.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private String chooseBadge(int benefitPrice) {
        return Badge.findBadgeByBenefitPrice(benefitPrice);
    }
}
