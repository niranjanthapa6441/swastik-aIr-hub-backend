package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Passenger;

import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, String> {
    @Query("SELECT p FROM Passenger p where p.booking=?1")
    List<Passenger> findPassengerByBookingId(Booking booking);

    @Query("SELECT count(*) FROM Passenger p where p.booking.flightTicket.detail.flightCode=?1")
    public int totalBookedSeats(String flightCode);
}
