package com.swastikairhub.SwastiKAirHubBackend.Service;

import com.swastikairhub.SwastiKAirHubBackend.DTO.PaymentDTO;
import com.swastikairhub.SwastiKAirHubBackend.Domain.Payment;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    Iterable<Payment> findPaymentByCustomerID(String id);
    Iterable<Payment> findAll();
    PaymentDTO delete(int id);
}
