package com.gudratli.springbootrabbitmq.config;

import com.gudratli.springbootrabbitmq.enums.EQueue;
import com.gudratli.springbootrabbitmq.enums.EExchange;
import com.gudratli.springbootrabbitmq.enums.ERoutingKey;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Dunay Gudratli
 * @mailto : d.qudretli@gmail.com
 * @since : 24.10.2023
 **/
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue queue ()
    {
        return new Queue(EQueue.TEST.getQueue());
    }

    @Bean
    public Queue jsonQueue (){
        return new Queue(EQueue.TEST_JSON.getQueue());
    }

    @Bean
    public TopicExchange exchange ()
    {
        return new TopicExchange(EExchange.TEST.getExchange());
    }

    @Bean
    public Binding binding ()
    {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(ERoutingKey.TEST.getRoutingKey());
    }

    @Bean
    public Binding jsonBinding ()
    {
        return BindingBuilder
                .bind(jsonQueue())
                .to(exchange())
                .with(ERoutingKey.TEST_JSON.getRoutingKey());
    }

    @Bean
    public MessageConverter messageConverter (){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate (ConnectionFactory factory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
