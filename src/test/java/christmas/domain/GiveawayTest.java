package christmas.domain;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GiveawayTest {

    @Test
    void 총_주문_금액이_12만원_이상일때_샴페인_한병을_증정이벤트로_반환한다() {
        Giveaway actual = new Giveaway(120_000);

        Map<Meal, Integer> giveaways = actual.getGiveaways();

        assertEquals(1, giveaways.get(Meal.CHAMPAGNE));
    }

    @Test
    void 총_주문_금액이_12만원_미만일때_증정이벤트는_없다() {
        Giveaway actual = new Giveaway(119_999);

        Map<Meal, Integer> giveaways = actual.getGiveaways();

        assertTrue(giveaways.isEmpty());
    }

    @Test
    void 총_주문_금액이_동일할_경우_Giveaway_객체도_동일하다() {
        Giveaway giveawayA = new Giveaway(120_000);
        Giveaway giveawayB = new Giveaway(120_000);

        assertEquals(giveawayA, giveawayB);
    }

}