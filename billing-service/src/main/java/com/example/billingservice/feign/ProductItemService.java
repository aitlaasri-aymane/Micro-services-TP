package com.example.billingservice.feign;

import com.example.billingservice.models.Product;
import jakarta.ws.rs.QueryParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductItemService {
    @GetMapping("/products")
    PagedModel<Product> getPageProducts(@RequestParam int page, @RequestParam int size);
    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable Long id);
}
