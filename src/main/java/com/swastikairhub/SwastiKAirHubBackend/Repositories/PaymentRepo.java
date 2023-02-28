package com.swastikairhub.SwastiKAirHubBackend.Repositories;

import com.swastikairhub.SwastiKAirHubBackend.Domain.Payment;
import com.swastikairhub.SwastiKAirHubBackend.User.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepo extends CrudRepository<Payment,String> {
    @Query("SELECT p FROM Payment p where p.booking.customer=?1")
    List<Payment> findPaymentByCustomerId(Optional<User> customer);
}
