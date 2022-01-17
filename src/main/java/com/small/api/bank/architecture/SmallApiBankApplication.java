package com.small.api.bank.architecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.small.api.bank.architecture"})
public class SmallApiBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmallApiBankApplication.class, args);
    }

}
