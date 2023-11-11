package christmas.domain;

import java.util.List;
import java.util.StringJoiner;

record Order(List<OrderUnit> list){

    Order{

    }

    String toFormat() {
        StringJoiner joiner = new StringJoiner("\n");
        list.forEach(it -> joiner.add(it.toString()));
        return joiner.toString();
    }
}
