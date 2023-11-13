package christmas.domain;

enum Constraint {
    MAX_ORDER_NUM(20),
    CHRISTMAS_DATE(25),
    PRICE_CORRESPONDING_TO_GIVEAWAY(120_000),
    ;
    private final int value;

    Constraint(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
