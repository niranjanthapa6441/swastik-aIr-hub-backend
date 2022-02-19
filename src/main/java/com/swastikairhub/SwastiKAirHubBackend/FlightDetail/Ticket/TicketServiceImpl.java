package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TicketServiceImpl implements  TicketService{
    @Autowired
    private TicketRepo repo;
    Ticket ticket;
    @Override
    public TicketDTO findTicketByID(int id) {
        Optional<Ticket> findTicket= repo.findById(id);
        if (findTicket.isPresent()){
            ticket=findTicket.get();
            return toTicketDTO(ticket);
        }
        else
            throw new NullPointerException("Ticket Doesn't Exist");
    }


    @Override
    public TicketDTO save(TicketRequest request) {
        ticket= repo.save(toTicket(request));
        return toTicketDTO(ticket);
    }

    @Override
    public Iterable<Ticket> findAll() {
        return repo.findAll();
    }

    @Override
    public TicketDTO update(int id, TicketRequest request) {
        Optional<Ticket> findTicket=repo.findById(id);
        if (findTicket.isPresent()){
            Ticket updateTicket= toTicket(request);
            updateTicket.setId(id);
            Ticket updatedTicket= repo.save(updateTicket);
            return toTicketDTO(updatedTicket);
        }
        else
            throw new NullPointerException("ticket does not exist");
    }

    @Override
    public TicketDTO delete(int id) {
        Optional<Ticket> findTicket=repo.findById(id);
        if (findTicket.isPresent()){
            Ticket deleteTicket=findTicket.get();
            deleteTicket.setStatus("Terminated");
            Ticket deletedTicket= repo.save(deleteTicket);
         return toTicketDTO(deletedTicket);
        }
        else
            throw new NullPointerException("ticket does not exist");
    }
    private Ticket toTicket(TicketRequest request) {
        ticket= new Ticket();
        ticket.setTicketCode(request.getTicketCode());
        ticket.setPrice(request.getPrice());
        ticket.setStatus(request.getStatus());
        return  ticket;
    }
    private TicketDTO toTicketDTO(Ticket ticket) {
        return TicketDTO.builder().id(ticket.getId()).
                price(ticket.getPrice()).Status(ticket.getStatus()).ticketCode(ticket.getTicketCode()).
                build();
    }

}
