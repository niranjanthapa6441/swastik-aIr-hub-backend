package com.swastikairhub.SwastiKAirHubBackend.Repositories;

import com.swastikairhub.SwastiKAirHubBackend.Domain.Booking;
import com.swastikairhub.SwastiKAirHubBackend.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepo extends JpaRepository<Booking,String> {
    @Query("SELECT bg FROM Booking bg where bg.customer=?1")
    List<Booking> findBookingByCustomerId(Optional<User> customer);
}
