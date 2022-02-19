package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket;

import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight.FlightDetail;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight.FlightRepo;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket.Ticket;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightTicketServiceImpl implements FlightTicketService{
    @Autowired
    private FlightTicketRepo repo;
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private FlightRepo flightRepo;
    @Override
    public Iterable<FlightTicket> findAll() {
        return repo.findAll();
    }

    @Override
    public List<FlightTicket> findFlightTicketByFlight() {
        return null;
    }

    @Override
    public FlightTicketDTO save(FlightTicketRequest request) {
        FlightTicket flightTicket=toFlight(request);
        FlightTicket savedFlightTicket=repo.save(flightTicket);
        return toFlightTicketDTO(savedFlightTicket);
    }

    private FlightTicketDTO toFlightTicketDTO(FlightTicket flightTicket) {
        return FlightTicketDTO.builder().id(flightTicket.getId()).
                flightDetail(flightTicket.getDetail()).
                ticket(flightTicket.getTicket()).build();
    }

    private FlightTicket toFlight(FlightTicketRequest request) {
        Ticket ticket=ticketRepo.findByTicketCode(request.getTicketCode());
        FlightDetail detail=flightRepo.findByFlightCode(request.getFlightCode());
        if (ticket == null)
            throw  new NullPointerException("The ticket doesn't exist");
        if (detail ==null)
            throw new NullPointerException("The flight does not exist");
        FlightTicket flightTicket=new FlightTicket();
        flightTicket.setTicket(ticket);
        flightTicket.setDetail(detail);
        return flightTicket;
    }
}
