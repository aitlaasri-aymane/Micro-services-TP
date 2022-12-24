package com.example.inventoryservice;

import com.example.inventoryservice.entities.Product;
import com.example.inventoryservice.repositories.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.stream.Stream;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepo productRepo, RepositoryRestConfiguration configuration){
        configuration.exposeIdsFor(Product.class);
        return args -> {
            Stream.of("P1","P2","P3","P4").forEach(name -> {
                Product product = Product.builder()
                        .name(name)
                        .quantity((long) Math.ceil(Math.random()*100))
                        .price(Math.random()*100+10)
                        .build();
                productRepo.save(product);
            });
        };
    }

}
