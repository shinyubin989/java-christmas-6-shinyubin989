package christmas.domain;

import java.util.HashSet;
import java.util.List;

enum Course {
    APPETIZER(List.of(Meal.MUSHROOM_SOUP, Meal.TAPAS, Meal.CAESAR_SALAD)),
    MAIN(List.of(Meal.T_BONE_STEAK, Meal.BBQ_RIBS, Meal.SEAFOOD_PASTA, Meal.CHRISTMAS_PASTA)),
    DESSERT(List.of(Meal.CHOCOLATE_CAKE, Meal.ICE_CREAM)),
    BEVERAGE(List.of(Meal.ZERO_COLA, Meal.RED_WINE, Meal.CHAMPAGNE)),
    ;

    private final List<Meal> meals;

    Course(List<Meal> meals) {
        this.meals = meals;
    }

    static boolean doesOrderOnlyContainBeverage(List<Meal> order) {
        return new HashSet<>(BEVERAGE.meals).containsAll(order);
    }
}
