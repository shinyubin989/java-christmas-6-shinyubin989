package christmas.domain;

import java.util.*;

class Order {

    private final List<OrderUnit> order = new ArrayList<>();

    public Order(List<OrderUnit> order) {
        validateDuplication(order);
    }

    private void validateDuplication(List<OrderUnit> order) {
        if(order.size() != order.stream().distinct().count())
            throw new IllegalArgumentException(DomainException.MENU_IS_DUPLICATED.getMessage());
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
