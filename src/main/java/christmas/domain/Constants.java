package christmas.domain;

public enum Constants {
    MAX_ORDER_NUM(20),
    CHRISTMAS_DATE(25),
    PRICE_CORRESPONDING_TO_GIVEAWAY(120_000),
    BENEFIT_START_PRICE(1000),
    DAILY_INCREASE_PRICE(100),
    WEEKDAY_BENEFIT_PRICE(2023),
    WEEKEND_BENEFIT_PRICE(2023),
    SPECIAL_DAY_BENEFIT_PRICE(1000),
    ;
    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
