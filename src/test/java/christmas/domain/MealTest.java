package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void 이름에_해당하는_Meal_객체를_반환한다() {
        String mealName = "양송이수프";

        Meal actual = Meal.findByName(mealName);

        assertEquals(Meal.MUSHROOM_SOUP, actual);
    }
}