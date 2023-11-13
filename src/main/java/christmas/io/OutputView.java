package christmas.io;

import java.text.DecimalFormat;
import java.util.Map;

public final class OutputView implements OutputPort {
    @Override
    public void printException(String message) {
        System.out.println(message);
    }

    @Override
    public void printIntroduction() {
        System.out.println(OutputMessage.INTRODUCTION.getMessage());
    }

    @Override
    public void printInputDate() {
        System.out.println(OutputMessage.INPUT_DATE.getMessage());
    }

    @Override
    public void printInputMenu() {
        System.out.println(OutputMessage.INPUT_MENU.getMessage());
    }

    @Override
    public void printBenefitPreview(int date) {
        System.out.println(String.format(OutputMessage.PREVIEW_BENEFIT.getMessage(), date));
        System.out.println();
    }

    @Override
    public void printOrderedMenu(Map<String, Integer> menus) {
        System.out.println(OutputMessage.ORDER_MENU.getMessage());
        menus.forEach((menu, num) -> {
            String formattedMenu = String.format("%s %d개", menu, num);
            System.out.println(formattedMenu);
        });
        System.out.println();
    }

    @Override
    public void printPriceBeforeBenefit(int price) {
        System.out.println(OutputMessage.PRICE_BEFORE_BENEFIT.getMessage());
        System.out.println(new DecimalFormat("###,###").format(price) + "원");
        System.out.println();
    }

    @Override
    public void printGiveawayMenu(Map<String, Integer> giveaways) {
        System.out.println(OutputMessage.GIVEAWAY_MENU.getMessage());
        if (giveaways.isEmpty()) {
            System.out.println("없음");
            System.out.println();
            return;
        }
        giveaways.forEach((menu, num) -> {
            String formattedMenu = String.format("%s %d개", menu, num);
            System.out.println(formattedMenu);
        });
        System.out.println();
    }

    @Override
    public void printBenefitList(Map<String, Integer> benefits) {
        System.out.println(OutputMessage.BENEFIT_LIST.getMessage());
        benefits.forEach((benefit, price) -> {
            if(price > 0) {
                String formattedBenefit = String.format("%s: -%,d원", benefit, price);
                System.out.println(formattedBenefit);
            }
        });
        System.out.println();
    }

    @Override
    public void printBenefitPrice(int price) {
        System.out.println(OutputMessage.BENEFIT_PRICE.getMessage());
        if(price == 0) {
            System.out.println("0원");
            System.out.println();
            return;
        }
        System.out.println(String.format("-%,d원", price));
        System.out.println();
    }

    @Override
    public void printPriceAfterBenefit(int price) {
        System.out.println(OutputMessage.PRICE_AFTER_BENEFIT.getMessage());
        System.out.println(new DecimalFormat("###,###").format(price) + "원");
        System.out.println();
    }

    @Override
    public void printEventBadge(String badge) {
        System.out.println(badge);
    }
}
