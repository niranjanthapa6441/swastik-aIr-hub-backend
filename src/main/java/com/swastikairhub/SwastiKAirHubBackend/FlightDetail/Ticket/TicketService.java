package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket;


import org.springframework.stereotype.Service;

@Service
public interface TicketService {
    TicketDTO findTicketByID(int id);
    TicketDTO save(TicketRequest request);
    Iterable<Ticket> findAll();
    TicketDTO update(int id,TicketRequest request);
    TicketDTO delete(int id);
}
