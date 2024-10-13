package com.work.scheduler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BidDTO {

    private String bidId;
    private String productId;
    private String userId;
    private Double bidAmount;
}
