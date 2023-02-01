package com.swastikairhub.SwastiKAirHubBackend.Domain;

import com.swastikairhub.SwastiKAirHubBackend.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepo extends JpaRepository<Booking,String> {
    @Query("SELECT bg FROM Booking bg where bg.customer=?1")
    Iterable<Booking> findBookingByCustomerId(Optional<User> customer);
}
