package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void 이름에_해당하는_Meal_객체를_반환한다() {
        String mealName = "양송이수프";

        Meal actual = Meal.findByName(mealName);

        assertEquals(Meal.MUSHROOM_SOUP, actual);
    }

    @Test
    void 해당하는_메뉴_이름이_없는경우_예외를_반환한다() {
        assertThatThrownBy(() -> Meal.findByName("없는이름"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}