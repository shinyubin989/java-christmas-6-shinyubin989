package christmas.domain;

import java.util.Arrays;

public enum Meal {

    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000),

    T_BONE_STEAK("티본스테이크", 55000),
    BBQ_RIBS("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000),

    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000),

    ZERO_COLA("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000),

    ;

    private final String name;
    private final int price;

    Meal(String name, int price) {
        this.name = name;
        this.price = price;
    }

    static Meal findByName(String name) {
        return Arrays.stream(values())
                .filter(it -> it.name.equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(DomainException.MENU_DOES_NOT_EXIST.getMessage()));
    }

    public int getPrice() {
        return price;
    }
}
