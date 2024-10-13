package com.work.notification.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WinnerDTO {

    private Long emailId;
    private Long productId;
    private Double winningBidAmount;


}
