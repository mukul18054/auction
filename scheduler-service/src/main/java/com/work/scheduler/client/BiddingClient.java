package com.work.scheduler.client;

import com.work.scheduler.dto.BidResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BiddingClient {

    @Autowired
    private RestTemplate restTemplate;

    // Endpoint for fetching bids for a specific product
    public BidResponse getBidsForProduct(String productId) {
        String url = "http://localhost:8081/v1/auction/bidding/getBidsByProductId/" + productId;
        return restTemplate.getForObject(url, BidResponse.class);
    }
}
