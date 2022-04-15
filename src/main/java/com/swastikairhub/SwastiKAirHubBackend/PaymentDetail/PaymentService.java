package com.swastikairhub.SwastiKAirHubBackend.PaymentDetail;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    Iterable<Payment> findPaymentByCustomerID(String id);
    Iterable<Payment> findAll();
    PaymentDTO delete(int id);
}
