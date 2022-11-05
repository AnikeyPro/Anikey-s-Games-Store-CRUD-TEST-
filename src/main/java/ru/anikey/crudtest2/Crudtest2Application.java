package ru.anikey.crudtest2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;
import ru.anikey.crudtest2.rabbitMQ.Runner;
import ru.anikey.crudtest2.restLogTest.RestLogTest;

@SpringBootApplication
public class Crudtest2Application {


    @Bean
    @Profile("RabbitMQON")
    public CommandLineRunner tutorial() {
        return new Runner();
    }

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Crudtest2Application.class);
        logger.info("Hello World");
        logger.debug("..w.");
        RestLogTest.SendRestRequest();
        SpringApplication.run(Crudtest2Application.class, args);
        logger.debug(".w..");
    }

}
