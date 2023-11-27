package ch.hslu.oop.sw08.elements;

public enum AggregateState {
    SOLID("fest"),
    LIQUID("fluessig"),
    GAS("gasfoermig");

    private final String name;

    AggregateState(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.name;
    }
}
