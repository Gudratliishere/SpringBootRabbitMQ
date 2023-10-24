package com.gudratli.springbootrabbitmq.publisher;

import com.gudratli.springbootrabbitmq.enums.EExchange;
import com.gudratli.springbootrabbitmq.enums.ERoutingKey;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * @author : Dunay Gudratli
 * @mailto : d.qudretli@gmail.com
 * @since : 24.10.2023
 **/
@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitMqProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage (String message)
    {
        log.info("Message sent -> {}", message);

        rabbitTemplate.convertAndSend(EExchange.TEST.getExchange(), ERoutingKey.TEST.getRoutingKey(), message);
    }
}
