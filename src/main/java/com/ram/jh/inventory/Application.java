package com.ram.jh.inventory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ram.jh.inventory.model.Products;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@SpringBootApplication
//@EnableAutoConfiguration//(exclude = { org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public Products getJsonFromFile() {

        Products products;
        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test.json");
        try {
            products = objectMapper.readValue(new InputStreamReader(inputStream),Products.class);
            return products;
        } catch (IOException e) {
            return null;
        }
    }
}
