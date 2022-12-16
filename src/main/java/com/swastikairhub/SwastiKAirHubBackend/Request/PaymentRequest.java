package com.swastikairhub.SwastiKAirHubBackend.Request;

import lombok.Data;

@Data
public class PaymentRequest {
    private String paymentMethod;
    private String status;
    private int paidAmount;
}
