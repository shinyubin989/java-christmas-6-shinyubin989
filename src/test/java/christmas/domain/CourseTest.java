package christmas.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void 음료_주문만_존재할_경우_True를_반환한다() {
        List<Meal> meals = List.of(Meal.ZERO_COLA, Meal.RED_WINE, Meal.CHAMPAGNE);

        assertTrue(Course.doesOrderOnlyContainBeverage(meals));
    }

}