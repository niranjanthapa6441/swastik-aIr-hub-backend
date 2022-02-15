package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Passenger;

import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Booking;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket.TicketDTO;
import org.springframework.stereotype.Service;

@Service
public interface PassengerService {
    Iterable<Passenger> findAll();
    PassengerDTO save(PassengerRequest request);
    PassengerDTO findPassengerByBookingID(String id);
    String delete(Booking booking);
}
