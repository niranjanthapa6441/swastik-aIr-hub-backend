package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Passenger;

import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, String> {
    @Query("SELECT count(*) FROM Passenger p where p.booking=?1")
    Iterable<Passenger> findPassengerByBookingId(Booking booking);
}
