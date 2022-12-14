package ru.anikey.crudtest2.rabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("RabbitMQON")
@Configuration
public class RabbitConfig {

//
//    @Bean
//    public CommandLineRunner tutorial() {
//        return new Runner();
//    }
    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }

//    @Bean
//    public Sender sender() {
//        return new Sender(template, queue);
//    }
}
