package com.gudratli.springbootrabbitmq.consumer;

import com.gudratli.springbootrabbitmq.model.User;
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
public class RabbitMqJsonConsumer {

    @RabbitListener(queues = "test_json")
    public void consumeJsonMessage(User user) {
        log.info("Json Message received -> {}", user);
    }
}
