package com.work.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
//import jakarta.persistence.*;


//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal basePrice;
    private String categoryId;
    private LocalDateTime biddingStartTime;
    private LocalDateTime biddingEndTime;

    // Constructors, getters, and setters
}
