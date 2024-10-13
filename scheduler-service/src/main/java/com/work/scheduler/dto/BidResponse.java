package com.work.scheduler.dto;


public class BidDTO {

    private Long bidId;
    private Long productId;
    private Long userId;
    private Double bidAmount;

    // Constructor, Getters, Setters

    public BidDTO(Long bidId, Long productId, Long userId, Double bidAmount) {
        this.bidId = bidId;
        this.productId = productId;
        this.userId = userId;
        this.bidAmount = bidAmount;
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Double bidAmount) {
        this.bidAmount = bidAmount;
    }
}
