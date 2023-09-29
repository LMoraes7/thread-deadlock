package org.example;

public enum Resource {
    RESOURCE_1(1),
    RESOURCE_2(2),
    RESOURCE_0(0);

    private final Integer value;

    Integer getValue() {
        return this.value;
    }

    Resource(final Integer value) {
        this.value = value;
    }

}
