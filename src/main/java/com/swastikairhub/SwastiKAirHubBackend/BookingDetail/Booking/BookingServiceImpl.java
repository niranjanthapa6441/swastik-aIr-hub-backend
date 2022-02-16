package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepo repo;

    @Override
    public Iterable<Booking> findAll() {
        return null;
    }

    @Override
    public BookingDTO update(String id, BookingRequest request) {
        return null;
    }

    @Override
    public BookingDTO save(BookingRequest request) {
        return null;
    }

    @Override
    public BookingDTO delete(String id) {
        return null;
    }

    @Override
    public BookingDTO findById(String id) {
        return null;
    }
}
