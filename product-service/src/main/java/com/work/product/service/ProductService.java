package com.work.product.service;

import com.work.product.model.Product;
import com.work.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProduct(String id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public List<Product> getActiveAuctions() {
        LocalDateTime now = LocalDateTime.now();
        return productRepository.findByBiddingStartTimeBeforeAndBiddingEndTimeAfter(now, now);
    }

    public boolean isValidBid(String productId, BigDecimal bidAmount) {
        Optional<Product> product = productRepository.findById(productId);
        return product.map(p -> bidAmount.compareTo(p.getBasePrice()) >= 0).orElse(false);
    }
}