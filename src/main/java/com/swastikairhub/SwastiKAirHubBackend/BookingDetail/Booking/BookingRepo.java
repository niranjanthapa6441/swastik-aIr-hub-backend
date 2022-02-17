package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking;

import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Passenger.Passenger;
import com.swastikairhub.SwastiKAirHubBackend.Customer.Customer;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking,String> {
    @Query("SELECT bg FROM Booking bg where bg.customer=?1")
    Iterable<Booking> findBookingByCustomerId(Customer customer);
}
