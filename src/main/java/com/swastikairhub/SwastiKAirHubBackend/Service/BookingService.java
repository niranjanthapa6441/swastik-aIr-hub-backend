package com.swastikairhub.SwastiKAirHubBackend.Service;

import com.swastikairhub.SwastiKAirHubBackend.Domain.Booking;
import com.swastikairhub.SwastiKAirHubBackend.DTO.BookingDTO;
import com.swastikairhub.SwastiKAirHubBackend.DTO.PassengerTicketDTO;
import com.swastikairhub.SwastiKAirHubBackend.Request.BookingRequest;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {
    Iterable<Booking> findAll();
    BookingDTO update(String id, BookingRequest request);
    BookingDTO save(BookingRequest request);
    BookingDTO delete(String id);
    BookingDTO findById(String id);
    Iterable<Booking> findByCustomerId(String id);
    Iterable<PassengerTicketDTO> findTicketByBookingId(String id);
}
