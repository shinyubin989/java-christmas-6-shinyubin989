package christmas.domain;

import christmas.dto.OrderDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void 주문에_중복이_있을경우_예외를_반환한다() {
        assertThatThrownBy(() -> new Order(List.of(new OrderDto("양송이수프", 1), new OrderDto("양송이수프", 1))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    }
}