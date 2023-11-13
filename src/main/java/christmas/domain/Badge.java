package christmas.domain;

enum Badge {

    STAR(5_000, "별"),
    TREE(10_000, "트리"),
    SANTA(20_000, "산타"),
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
}
