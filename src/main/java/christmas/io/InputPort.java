package christmas.io;

import christmas.dto.OrderDto;

import java.util.List;

public interface InputPort {
    int readDate();

    List<OrderDto> readMenus();
}
