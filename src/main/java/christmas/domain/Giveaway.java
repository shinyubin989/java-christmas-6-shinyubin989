package christmas.domain;

import java.util.EnumMap;
import java.util.Map;

final class Giveaway {

    private Map<Meal, Integer> giveaways;

    public Giveaway(int totalPrice) {
        giveaways = new EnumMap<>(Meal.class);
        if(totalPrice >= Constants.PRICE_CORRESPONDING_TO_GIVEAWAY.getValue()) {
            giveaways = Map.of(Meal.CHAMPAGNE, 1);
        }
    }

    Map<Meal, Integer> getGiveaways() {
        return giveaways;
    }
}
