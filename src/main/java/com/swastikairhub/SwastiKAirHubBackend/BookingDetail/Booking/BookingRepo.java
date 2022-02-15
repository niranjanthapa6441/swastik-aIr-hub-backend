package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking;

import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Passenger.Passenger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends CrudRepository<Booking,String> {

}
