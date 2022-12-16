package com.swastikairhub.SwastiKAirHubBackend.DTO;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class PaymentDTO {
    private String id;
    private String bookingId;
    private int totalAmount;
    private String paymentMethod;
    private LocalDate paymentDate;
    private LocalTime paymentTIme;
    private String status;
}
