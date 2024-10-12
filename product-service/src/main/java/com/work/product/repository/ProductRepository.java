
package com.work.product.repository;

import com.work.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByCategoryId(String categoryId);
    List<Product> findByBiddingStartTimeBeforeAndBiddingEndTimeAfter(LocalDateTime start, LocalDateTime end);
}
