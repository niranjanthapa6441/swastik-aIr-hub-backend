package com.swastikairhub.SwastiKAirHubBackend.PaymentDetail;

import lombok.Data;

@Data
public class PaymentRequest {
    private String paymentMethod;
    private String status;
    private int paidAmount;
}
