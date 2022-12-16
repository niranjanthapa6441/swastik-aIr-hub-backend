package com.swastikairhub.SwastiKAirHubBackend.Service;


import com.swastikairhub.SwastiKAirHubBackend.DTO.TicketDTO;
import com.swastikairhub.SwastiKAirHubBackend.Domain.Ticket;
import com.swastikairhub.SwastiKAirHubBackend.Request.TicketRequest;
import org.springframework.stereotype.Service;

@Service
public interface TicketService {
    TicketDTO findTicketByID(int id);
    TicketDTO save(TicketRequest request);
    Iterable<Ticket> findAll();
    TicketDTO update(int id,TicketRequest request);
    TicketDTO delete(int id);
}
