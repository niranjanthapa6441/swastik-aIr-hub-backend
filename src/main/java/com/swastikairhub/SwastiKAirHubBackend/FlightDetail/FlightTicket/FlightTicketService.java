package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightTicketService {
    Iterable<FlightTicket> findAll();
    List<FlightTicket> findFlightTicketByFlight();
    FlightTicketDTO save(FlightTicketRequest request);
}
