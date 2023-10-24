package com.gudratli.springbootrabbitmq.controller;

import com.gudratli.springbootrabbitmq.model.User;
import com.gudratli.springbootrabbitmq.publisher.RabbitMqJsonProducer;
import com.gudratli.springbootrabbitmq.publisher.RabbitMqProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Dunay Gudratli
 * @mailto : d.qudretli@gmail.com
 * @since : 24.10.2023
 **/
@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final RabbitMqProducer rabbitMqProducer;
    private final RabbitMqJsonProducer rabbitMqJsonProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestPart String message) {
        rabbitMqProducer.sendMessage(message);

        return ResponseEntity.ok("Message was sent successfully!");
    }

    @PostMapping("/publishUser")
    public ResponseEntity<String> sendMessage(@RequestBody User user) {
        rabbitMqJsonProducer.sendJsonMessage(user);

        return ResponseEntity.ok("Message was sent successfully!");
    }
}
