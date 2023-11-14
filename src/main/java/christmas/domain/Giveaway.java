package christmas.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

final class Giveaway {

    private Map<Meal, Integer> giveaways;

    public Giveaway(int totalPrice) {
        giveaways = new EnumMap<>(Meal.class);
        if(totalPrice >= Constants.PRICE_CORRESPONDING_TO_GIVEAWAY.getValue()) {
            giveaways = Map.of(Meal.CHAMPAGNE, 1);
        }
    }

    Map<Meal, Integer> getGiveaways() {
        return new EnumMap<>(giveaways);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Giveaway giveaway = (Giveaway) o;
        return Objects.equals(giveaways, giveaway.giveaways);
    }

    @Override
    public int hashCode() {
        return Objects.hash(giveaways);
    }
}
