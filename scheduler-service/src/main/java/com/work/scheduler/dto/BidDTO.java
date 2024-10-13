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

    private Long bidId;
    private Long productId;
    private Long userId;
    private Double bidAmount;
}
