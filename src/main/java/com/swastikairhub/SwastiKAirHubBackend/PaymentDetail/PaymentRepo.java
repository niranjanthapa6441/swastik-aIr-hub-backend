package com.swastikairhub.SwastiKAirHubBackend.PaymentDetail;

import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Booking;
import com.swastikairhub.SwastiKAirHubBackend.User.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepo extends CrudRepository<Payment,String> {
    @Query("SELECT p FROM Payment p where p.booking.customer=?1")
    Iterable<Payment> findPaymentByCustomerId(Optional<User> customer);
}
