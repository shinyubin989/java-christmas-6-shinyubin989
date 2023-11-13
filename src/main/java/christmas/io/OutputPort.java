package christmas.io;

import java.util.List;
import java.util.Map;

public interface OutputPort {
    void printException(String message);
    void printIntroduction();

    void printInputDate();

    void printInputMenu();

    void printBenefitPreview(int date);

    void printOrderedMenu(Map<String, Integer> menus);

    void printPriceBeforeBenefit(int price);

    void printGiveawayMenu(Map<String, Integer> menu);

    void printBenefitList(Map<String, Integer> list);

    void printBenefitPrice(int price);

    void printPriceAfterBenefit(int price);

    void printEventBadge(String badge);

}
