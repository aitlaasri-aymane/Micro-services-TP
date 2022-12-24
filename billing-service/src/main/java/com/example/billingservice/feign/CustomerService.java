package com.example.billingservice.feign;

import com.example.billingservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerService {
    @GetMapping(path = "/api/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);
}
