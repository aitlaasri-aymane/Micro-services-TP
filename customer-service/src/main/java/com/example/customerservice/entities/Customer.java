package com.example.customerservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}