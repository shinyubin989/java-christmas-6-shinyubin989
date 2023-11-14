package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class OrderUnitTest {

    @Test
    void 단건_주문갯수가_1보다_작을_경우_예외를_발생시킨다() {
        assertThatThrownBy(() -> new OrderUnit("양송이수프", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

}