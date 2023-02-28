package com.swastikairhub.SwastiKAirHubBackend.Service;

import com.swastikairhub.SwastiKAirHubBackend.DTO.PaymentDTO;
import com.swastikairhub.SwastiKAirHubBackend.Domain.Payment;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    Page<Payment> findPaymentByCustomerID(String id, int page, int size);
    Iterable<Payment> findAll();
    PaymentDTO delete(int id);
}
