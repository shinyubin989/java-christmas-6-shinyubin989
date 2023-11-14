package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadgeTest {

    @Test
    void 혜택금액이_오천원_이하일_경우_배지를_반환하지_않는다() {
        String actual = Badge.findBadgeByBenefitPrice(4999);

        assertEquals(Badge.NONE.getBadgeName(), actual);
    }

}