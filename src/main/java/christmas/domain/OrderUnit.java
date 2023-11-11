package christmas.domain;

import java.util.Objects;

class OrderUnit implements Pair<Meal, Integer> {

    private final Meal menu;
    private final int num;

    public OrderUnit(String menu, int num) {
        this.menu = Meal.findByName(menu);
        this.num = validateNum(num);
    }

    private int validateNum(int num) {
        if(num < 1) throw new IllegalArgumentException(DomainException.MENU_NUM_MUST_BE_AT_LEAST_ONE.getMessage());
        return num;
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
