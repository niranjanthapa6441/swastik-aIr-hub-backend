package com.swastikairhub.SwastiKAirHubBackend.PaymentDetail;

import com.swastikairhub.SwastiKAirHubBackend.User.User;
import com.swastikairhub.SwastiKAirHubBackend.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    UserRepo userRepo;
    @Override
    public Iterable<Payment> findPaymentByCustomerID(String id) {
        Optional<User> customer= userRepo.findById(id);
        Iterable<Payment> customerPayment= paymentRepo.findPaymentByCustomerId(customer);
        return customerPayment;
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
