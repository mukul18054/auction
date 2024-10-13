package com.work.scheduler.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WinnerDTO {

    private String emailId;
    private String productId;
    private Double winningBidAmount;


}
