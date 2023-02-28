package com.swastikairhub.SwastiKAirHubBackend.ServiceImpl;

import com.swastikairhub.SwastiKAirHubBackend.Domain.Booking;
import com.swastikairhub.SwastiKAirHubBackend.Domain.Payment;
import com.swastikairhub.SwastiKAirHubBackend.DTO.PaymentDTO;
import com.swastikairhub.SwastiKAirHubBackend.Repositories.PaymentRepo;
import com.swastikairhub.SwastiKAirHubBackend.Service.PaymentService;
import com.swastikairhub.SwastiKAirHubBackend.User.User;
import com.swastikairhub.SwastiKAirHubBackend.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    UserRepo userRepo;
    @Override
    public Page<Payment> findPaymentByCustomerID(String id, int page, int size) {
        Optional<User> customer= userRepo.findById(id);
        List<Payment> customerPayment= paymentRepo.findPaymentByCustomerId(customer);
        Pageable pageable = PageRequest.of(page, size);
        Page<Payment> resultPage = null;
        if (customerPayment.size() > 0) {
            int from = page * size;
            int to = from + size;
            if (customerPayment.size() < to) {
                to = customerPayment.size();
            }
            resultPage = new PageImpl<>(customerPayment.subList(from, to), pageable, customerPayment.size()); // list is sliced according to page number and size
        }
        return resultPage;
    }

    @Override
    public Iterable<Payment> findAll() {
        return null;
    }

    @Override
    public PaymentDTO delete(int id) {
        return null;
    }
}
