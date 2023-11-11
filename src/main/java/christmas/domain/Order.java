package christmas.domain;

import java.util.List;
import java.util.StringJoiner;

record Order(List<OrderUnit> list){

    String toFormat() {
        StringJoiner joiner = new StringJoiner("\n");
        list.forEach(it -> joiner.add(it.toFormat()));
        return joiner.toString();
    }
}
