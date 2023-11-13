package christmas.io;

import christmas.dto.OrderDto;

import java.util.ArrayList;
import java.util.List;

public final class InputView implements InputPort {

    private final InputReader inputReader;

    public InputView(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    @Override
    public int readDate() {
        try {
            return Integer.parseInt(inputReader.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IoException.DATE_IS_NOT_NUMBER.getMessage());
        }
    }

    @Override
    public List<OrderDto> readMenus() {
        String input = inputReader.readLine();

        List<OrderDto> orders = new ArrayList<>();

        splitInputByComma(input).forEach(order -> {
            orders.add(toOrderDto(order));
        });

        return orders;
    }

    private List<String> splitInputByComma(String input) {
        return List.of(input.split(",", -1));
    }

    private OrderDto toOrderDto(String order) {
        List<String> splitOrder = List.of(order.split("-", -1));
        if(splitOrder.size() != 2) throw new IllegalArgumentException(IoException.MENU_FORMAT_IS_INVALID.getMessage());
        return new OrderDto(splitOrder.get(0), mapToInt(splitOrder.get(1)));
    }

    private int mapToInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IoException.NUM_OF_ORDER_IS_NOT_NUMBER.getMessage());
        }
    }
}
