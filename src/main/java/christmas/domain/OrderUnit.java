package christmas.domain;

record OrderUnit(String menu, int num) implements Pair<String, Integer> {

    @Override
    public String toFormat() {
        return menu + " " + num + "개";
    }
}
