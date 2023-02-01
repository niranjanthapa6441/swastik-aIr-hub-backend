package com.swastikairhub.SwastiKAirHubBackend.Service;

import com.swastikairhub.SwastiKAirHubBackend.Domain.Booking;
import com.swastikairhub.SwastiKAirHubBackend.Domain.Passenger;
import com.swastikairhub.SwastiKAirHubBackend.DTO.PassengerDTO;
import com.swastikairhub.SwastiKAirHubBackend.Request.PassengerRequest;
import org.springframework.stereotype.Service;

@Service
public interface PassengerService {
    Iterable<Passenger> findAll();
    PassengerDTO save(PassengerRequest request);
    PassengerDTO findPassengerByBookingID(String id);
    String delete(Booking booking);
}
