package christmas.domain;

import java.util.Arrays;

enum Badge {

    SANTA(20_000, "산타"),
    TREE(10_000, "트리"),
    STAR(5_000, "별"),
    NONE(0, "없음")
    ;

    private final int benefitPrice;
    private final String badgeName;

    Badge(int benefitPrice, String badgeName) {
        this.benefitPrice = benefitPrice;
        this.badgeName = badgeName;
    }

    public int getBenefitPrice() {
        return benefitPrice;
    }

    public String getBadgeName() {
        return badgeName;
    }

    static String findBadgeByBenefitPrice(int benefitPrice) {
        return Arrays.stream(Badge.values())
                .filter(badge -> benefitPrice >= badge.getBenefitPrice())
                .findFirst()
                .map(Badge::getBadgeName)
                .orElse(NONE.badgeName);
    }
}
