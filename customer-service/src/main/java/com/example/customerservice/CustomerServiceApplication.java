package com.example.customerservice;

import com.example.customerservice.entities.Customer;
import com.example.customerservice.repositories.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.stream.Stream;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepo customerRepo, RepositoryRestConfiguration configuration){
        configuration.exposeIdsFor(Customer.class);
        return args -> {
            Stream.of("Aymane","Imad","Khalid","Mehdi").forEach(name -> {
                Customer customer = Customer.builder()
                        .name(name)
                        .email(name+"gmail.com")
                        .build();
                customerRepo.save(customer);
            });
        };
    }

}
