package com.work.bidding.controller;

import com.work.biddingservice.dto.BidRequest;
import com.work.biddingservice.model.Bid;
import com.work.biddingservice.service.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bids")
public class BiddingController {
    private final BiddingService biddingService;

    @Autowired
    public BiddingController(BiddingService biddingService) {
        this.biddingService = biddingService;
    }

    @PostMapping
    public ResponseEntity<Bid> placeBid(@RequestBody BidRequest bidRequest) {
        Bid bid = biddingService.placeBid(bidRequest.getProductId(), bidRequest.getUserId(), bidRequest.getBidAmount());
        return new ResponseEntity<>(bid, HttpStatus.CREATED);
    }

    @GetMapping("/{productId}/winner")
    public ResponseEntity<Bid> getWinningBid(@PathVariable String productId) {
        Bid winningBid = biddingService.getWinningBid(productId);
        if (winningBid == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(winningBid, HttpStatus.OK);
    }

//    // Inner class for bid request
//    private static class BidRequest {
//        private String productId;
//        private String userId;
//        private BigDecimal bidAmount;
//
//        // Getters and setters
//    }
}