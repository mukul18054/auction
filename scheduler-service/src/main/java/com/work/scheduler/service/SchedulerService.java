package com.work.scheduler.service;

import com.work.scheduler.client.BiddingClient;
import com.work.scheduler.client.ProductClient;
import com.work.scheduler.dto.BidDTO;
import com.work.scheduler.dto.ProductDTO;
import com.work.scheduler.dto.WinnerDTO;
import com.work.scheduler.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SchedulerService {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private BiddingClient biddingClient;

    @Autowired
    private KafkaProducer kafkaProducer;

    public void processExpiredProducts() {
        List<ProductDTO> expiredProducts = productClient.getExpiredProducts();

        for (ProductDTO product : expiredProducts) {
            List<BidDTO> bids = biddingClient.getBidsForProduct(product.getId()).getBids();
            WinnerDTO winner = determineWinner(product, bids);
            if (winner != null) {
                kafkaProducer.sendWinnerNotification(winner);
            }
        }
    }

    private WinnerDTO determineWinner(ProductDTO product, List<BidDTO> bids) {
        BidDTO highestBid = bids.stream()
                .max(Comparator.comparing(BidDTO::getBidAmount))
                .orElse(null);

        if (highestBid != null) {
            return new WinnerDTO(highestBid.getUserId(), product.getProductId(), highestBid.getBidAmount());
        }
        return null;
    }
}
