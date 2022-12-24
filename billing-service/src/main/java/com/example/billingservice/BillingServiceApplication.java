package com.example.billingservice;

import com.example.billingservice.entities.Bill;
import com.example.billingservice.entities.ProductItem;
import com.example.billingservice.feign.CustomerService;
import com.example.billingservice.feign.ProductItemService;
import com.example.billingservice.models.Customer;
import com.example.billingservice.models.Product;
import com.example.billingservice.repositories.BillRepo;
import com.example.billingservice.repositories.ProductItemRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillRepo billRepo, ProductItemRepo productItemRepo, CustomerService customerService, ProductItemService productItemService){
        return args -> {
            Customer customer = customerService.getCustomerById(1L);
            Bill bill = Bill.builder()
                    .billingDate(new Date())
                    .customer(customer)
                    .customerID(customer.getId())
                    .productItems(null)
                    .build();
            billRepo.save(bill);
            System.out.println(customer);
            PagedModel<Product> products = productItemService.getPageProducts(0,5);
            products.forEach(p -> {
                ProductItem productItem= ProductItem.builder()
                        .bill(bill)
                        .product(p)
                        .productID(p.getId())
                        .quantity(p.getQuantity())
                        .price(p.getPrice())
                        .build();
                System.out.println(p);
                productItemRepo.save(productItem);
            });
        };
    }
}
