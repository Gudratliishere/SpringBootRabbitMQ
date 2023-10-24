package com.gudratli.springbootrabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author : Dunay Gudratli
 * @mailto : d.qudretli@gmail.com
 * @since : 24.10.2023
 **/
@Service
@Slf4j
public class RabbitMqConsumer {
    @RabbitListener(queues = {"test"})
    public void consume(String message) {
        log.info("Message received -> {}", message);
    }
}
