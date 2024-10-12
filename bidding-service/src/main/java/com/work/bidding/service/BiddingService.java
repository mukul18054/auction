package com.work.bidding.service;

import com.work.biddingservice.model.Bid;
import com.work.biddingservice.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BiddingService {
    private final BidRepository bidRepository;

    @Autowired
    public BiddingService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    public Bid placeBid(String productId, String userId, BigDecimal bidAmount) {
        // Here you would typically check if the bid is valid (e.g., higher than base price)
        // For simplicity, we're skipping those checks
        Bid bid = new Bid(productId, userId, bidAmount);
        return bidRepository.save(bid);
    }

    public Bid getWinningBid(String productId) {
        List<Bid> bids = bidRepository.findByProductIdOrderByBidAmountDesc(productId);
        return bids.isEmpty() ? null : bids.get(0);
    }
}