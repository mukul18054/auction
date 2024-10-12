package com.work.bidding.service;

import com.work.bidding.dto.BidRequest;
import com.work.bidding.impl.BiddingServiceImpl;
import com.work.bidding.model.Bid;
import com.work.bidding.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class BiddingService {
    private final BidRepository bidRepository;


    @Autowired
    public BiddingService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    public Bid placeBid(BidRequest bidRequest) {
        // Here you would typically check if the bid is valid (e.g., higher than base price)
        // For simplicity, we're skipping those checks
        Bid bid = BiddingServiceImpl.getBid(bidRequest);
        return bidRepository.insert(bid);
    }

    public Bid getWinningBid(String productId) {
        List<Bid> bids = bidRepository.findByProductIdOrderByBidAmountDesc(productId);
        return bids.isEmpty() ? null : bids.get(0);
    }

    public List<Bid> getBidsByUserId(String userId) {
        return bidRepository.findActiveBidsByUserId(userId);
    }

    public void deleteBid(String bidId) {
        bidRepository.deleteById(bidId);
    }

    public Bid updateBid(Bid bid) {
        return bidRepository.save(bid);
    }

    public String getBidId(BidRequest bidRequest) {
        return BiddingServiceImpl.constructBidId(bidRequest);
    }

    public Optional<Bid> getBid(String bidId) {
        return bidRepository.findById(bidId);
    }
}