package christmas.domain;

import java.util.Objects;

class OrderUnit implements Pair<String, Integer> {

    private final String menu;
    private final int num;

    public OrderUnit(String menu, int num) {
        validate();
        this.menu = menu;
        this.num = num;
    }

    private void validate() {

    }

    @Override
    public String toString() {
        return menu + " " + num + "개";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderUnit target = (OrderUnit) o;
        return menu.equals(target.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu);
    }
}
