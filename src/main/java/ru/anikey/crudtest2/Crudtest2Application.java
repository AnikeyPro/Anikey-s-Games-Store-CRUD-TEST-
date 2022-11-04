package ru.anikey.crudtest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages= {"ru.anikey.crudtest2.controller"})
public class Crudtest2Application {

    public static void main(String[] args) {
        SpringApplication.run(Crudtest2Application.class, args);
    }

}
