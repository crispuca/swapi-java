package com.demo.swapijava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SwapiJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwapiJavaApplication.class, args);
    }

}
