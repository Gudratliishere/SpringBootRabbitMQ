package com.gudratli.springbootrabbitmq.enums;

/**
 * @author : Dunay Gudratli
 * @mailto : d.qudretli@gmail.com
 * @since : 24.10.2023
 **/
public enum EExchange {
    TEST("test");

    private final String exchange;

    EExchange(String queue) {
        this.exchange = queue;
    }

    public String getExchange() {
        return exchange;
    }
}
