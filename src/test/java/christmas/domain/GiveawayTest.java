package christmas.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    void Giveaway_내부필드가_동일하다면_객체도_동일하다() {
        Giveaway giveawayA = new Giveaway(120_000);
        Giveaway giveawayB = new Giveaway(120_000);

        assertEquals(giveawayA, giveawayB);
    }

    @Test
    void Giveaway_내부_필드가_동일하다면_hash_자료구조에서도_동일한_객체로_취급한다() {
        Giveaway giveawayA = new Giveaway(120_000);
        Giveaway giveawayB = new Giveaway(120_000);
        Set<Giveaway> set = new HashSet<>();

        set.add(giveawayA);
        set.add(giveawayB);

        assertEquals(1, set.size());
    }
}