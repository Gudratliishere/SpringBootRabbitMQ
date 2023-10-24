package com.gudratli.springbootrabbitmq.enums;

/**
 * @author : Dunay Gudratli
 * @mailto : d.qudretli@gmail.com
 * @since : 24.10.2023
 **/
public enum ERoutingKey {
    TEST("test"),
    TEST_JSON("test_json");

    private final String routingKey;

    ERoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getRoutingKey() {
        return routingKey;
    }
}
