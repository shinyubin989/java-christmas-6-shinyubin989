package christmas.io;

import java.util.List;

public interface OutputPort {
    void printException(String message);
    void printIntroduction();

    void printInputDate();

    void printInputMenu();

    void printBenefitPreview();

    void printOrderedMenu(List<String> menus);

    void printPriceBeforeBenefit(int price);

    void printGiveawayMenu(String menu);

    void printBenefitList(List<String> list);

    void printBenefitPrice(int price);

    void printPriceAfterBenefit(int price);

    void printEventBadge(String badge);

}
