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

    @Test
    void 음료외의_주문이_존재할_경우_False를_반환한다() {
        List<Meal> meals = List.of(Meal.ZERO_COLA, Meal.RED_WINE, Meal.CHAMPAGNE, Meal.CHRISTMAS_PASTA);

        assertFalse(Course.doesOrderOnlyContainBeverage(meals));
    }

    @Test
    void isDessertMenu_메소드는_디저트_메뉴라면_true를_반환한다() {
        assertTrue(Course.isDessertMenu(Meal.CHOCOLATE_CAKE));
    }

    @Test
    void isDessertMenu_메소드는_디저트_메뉴가_아니라면_false를_반환한다() {
        assertFalse(Course.isDessertMenu(Meal.T_BONE_STEAK));
    }

    @Test
    void isMainMenu_메소드는_메인_메뉴라면_true를_반환한다() {
        assertTrue(Course.isMainMenu(Meal.T_BONE_STEAK));
    }

    @Test
    void isMainMenu_메소드는_메인_메뉴가_아니라면_false를_반환한다() {
        assertFalse(Course.isMainMenu(Meal.CHOCOLATE_CAKE));
    }

}