package com.work.bidding.model;

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
@Document(collection = "bids")
public class Bid {
    @Id
    private String id;
    private String productId;
    private String userId;
    private BigDecimal bidAmount;
    private LocalDateTime bidTime;

    // Constructors, getters, and setters

    public Bid(String productId, String userId, BigDecimal bidAmount) {
        this.productId = productId;
        this.userId = userId;
        this.bidAmount = bidAmount;
        this.bidTime = LocalDateTime.now();
    }

    // Getters and setters
}