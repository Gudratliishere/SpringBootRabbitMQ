package com.gudratli.springbootrabbitmq.enums;

/**
 * @author : Dunay Gudratli
 * @mailto : d.qudretli@gmail.com
 * @since : 24.10.2023
 **/
public enum EQueue {
    TEST("test"),
    TEST_JSON("test_json");

    private final String queue;

    EQueue(String queue) {
        this.queue = queue;
    }

    public String getQueue() {
        return queue;
    }
}
