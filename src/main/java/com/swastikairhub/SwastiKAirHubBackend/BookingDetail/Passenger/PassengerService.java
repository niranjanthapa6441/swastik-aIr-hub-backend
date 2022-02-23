package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Passenger;

import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Booking;
import org.springframework.stereotype.Service;

@Service
public interface PassengerService {
    Iterable<Passenger> findAll();
    PassengerDTO save(PassengerRequest request);
    PassengerDTO findPassengerByBookingID(String id);
    String delete(Booking booking);
}
