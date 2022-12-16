package com.swastikairhub.SwastiKAirHubBackend.Service;

import com.swastikairhub.SwastiKAirHubBackend.DTO.FlightTicketDTO;
import com.swastikairhub.SwastiKAirHubBackend.Domain.FlightTicket;
import com.swastikairhub.SwastiKAirHubBackend.Request.FlightTicketRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightTicketService {
    Iterable<FlightTicket> findAll();
    List<FlightTicket> findFlightTicketByFlight();
    FlightTicketDTO save(FlightTicketRequest request);
}
