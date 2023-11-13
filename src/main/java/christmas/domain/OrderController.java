package christmas.domain;

import christmas.domain.benefit.Benefits;
import christmas.dto.OrderDto;
import christmas.io.InputPort;
import christmas.io.OutputPort;

import java.time.DateTimeException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class OrderController {

    private final InputPort inputPort;
    private final OutputPort outputPort;

    OrderController(InputPort inputPort, OutputPort outputPort) {
        this.inputPort = inputPort;
        this.outputPort = outputPort;
    }

    VisitDate receiveDate() {
        while (true) {
            try {
                return new VisitDate(inputPort.readDate());
            } catch (IllegalArgumentException e) {
                outputPort.printException(e.getMessage());
            } catch (DateTimeException e) {
                outputPort.printException(DomainException.INVALID_DATE.getMessage());
            }
        }
    }

    Order receiveOrder() {
        while (true) {
            try {
                List<OrderDto> orders = inputPort.readMenus();
                return new Order(orders);
            } catch (IllegalArgumentException e) {
                outputPort.printException(e.getMessage());
            }
        }
    }

    void showReceipt(Receipt receipt) {
        outputPort.printOrderedMenu(receipt.order().getOrderDetails());
        outputPort.printPriceBeforeBenefit(receipt.priceBeforeBenefit());
        outputPort.printGiveawayMenu(convertGiveaways(receipt.giveaway()));
        outputPort.printBenefitList(convertBenefits(receipt.benefits()));
        outputPort.printBenefitPrice(calculateBenefitPrice(receipt.benefits()));
        outputPort.printPriceAfterBenefit(receipt.priceAfterBenefit());
        outputPort.printEventBadge(receipt.badge());
    }



    private Map<String, Integer> convertGiveaways(Giveaway giveaway) {
        return giveaway.getGiveaways().entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getName(),
                        Map.Entry::getValue
                ));
    }

    private Map<String, Integer> convertBenefits(Map<Benefits, Integer> target) {
        return target.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getName(),
                        Map.Entry::getValue
                ));
    }

    private int calculateBenefitPrice(Map<Benefits, Integer> benefits) {
        return benefits.values().stream()
                .mapToInt(i -> i)
                .sum();
    }


}
