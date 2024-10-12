package com.work.bidding.repository;

import com.work.bidding.model.Bid;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends MongoRepository<Bid, String> {
    List<Bid> findByProductIdOrderByBidAmountDesc(String productId);
}