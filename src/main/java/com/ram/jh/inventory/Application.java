package com.ram.jh.inventory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ram.jh.inventory.model.Products;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Gson buildGson() {
        return new GsonBuilder().create();
    }

    /*
    @Bean
    public Products getJsonFromFile() {

        Optional<Products> users;
        Gson gson = new GsonBuilder().create();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("products.json");
        assert inputStream != null;
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
        users = Optional.of(gson.fromJson(reader, Products.class));
        return users.get();
    }
    */

    @Bean
    public Products getListOfProductFromURL() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Products> entity = new HttpEntity<>(headers);
        ResponseEntity<Products> restRes = new RestTemplate()
                        .exchange("https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma",
                                        HttpMethod.GET, entity, Products.class);
        return restRes.getBody();
    }
}
