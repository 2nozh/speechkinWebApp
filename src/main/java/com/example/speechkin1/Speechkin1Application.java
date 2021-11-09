package com.example.speechkin1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Speechkin1Application {

    public static void main(String[] args) {

        SpringApplication.run(Speechkin1Application.class, args);
    }

}
