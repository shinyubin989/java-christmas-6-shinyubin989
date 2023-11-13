package christmas.domain;

import christmas.dto.OrderDto;

import java.util.*;
import java.util.stream.Collectors;

public class Order {

    private final List<OrderUnit> order = new ArrayList<>();

    public Order(List<OrderDto> inputOrders) {
        inputOrders.forEach(orderDto -> {
            order.add(new OrderUnit(orderDto.menuName(), orderDto.menuNum()));
        });
        validateDuplication(order);
        validateOrderNum();
        validateBeverageOnly();
    }

    private void validateDuplication(List<OrderUnit> order) {
        if(order.size() != order.stream().distinct().count())
            throw new IllegalArgumentException(DomainException.MENU_IS_DUPLICATED.getMessage());
    }

    private void validateOrderNum() {
        if(order.stream().mapToInt(OrderUnit::getNum).sum() > Constants.MAX_ORDER_NUM.getValue())
            throw new IllegalArgumentException(DomainException.MENU_NUM_EXCEEDS_20.getMessage());
    }

    private void validateBeverageOnly() {
        if (Course.doesOrderOnlyContainBeverage(order.stream().map(OrderUnit::getMenu).collect(Collectors.toList()))) {
            throw new IllegalArgumentException(DomainException.ORDERS_ONLY_CONTAIN_BEVERAGE.getMessage());
        }
    }

    public int sumOfAllOrders() {
        return order.stream().mapToInt(OrderUnit::getPrice).sum();
    }

    public int countDessertMenuNum() {
        return (int) order.stream().filter(OrderUnit::isDessertMenu).count();
    }

    public int countMainMenuNum() {
        return (int) order.stream().filter(OrderUnit::isMainMenu).count();
    }

    public Map<String, Integer> getOrderDetails() {
        Map<String, Integer> orders = new HashMap<>();
        order.forEach(it -> orders.put(it.getMenuName(), it.getNum()));
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order target = (Order) o;
        return Objects.equals(order, target.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        order.forEach(it -> joiner.add(it.toString()));
        return joiner.toString();
    }
}
