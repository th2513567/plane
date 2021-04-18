package com.lhc.plane.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BuyTicketDto {
    private Long userId;
    private Long planeId;
    private LocalDate planeDate;
}
