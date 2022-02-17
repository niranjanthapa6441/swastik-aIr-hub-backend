package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    Iterable<Booking> findAll();
    BookingDTO update(String id,BookingRequest request);
    BookingDTO save(BookingRequest request);
    BookingDTO delete(String id);
    BookingDTO findById(String id);
    Iterable<Booking> findByCustomerId(String id);
}
