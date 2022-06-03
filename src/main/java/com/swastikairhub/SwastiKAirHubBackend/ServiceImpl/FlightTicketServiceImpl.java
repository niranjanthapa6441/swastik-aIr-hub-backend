package com.swastikairhub.SwastiKAirHubBackend.ServiceImpl;

import com.swastikairhub.SwastiKAirHubBackend.Domain.FlightDetail;
import com.swastikairhub.SwastiKAirHubBackend.Repositories.FlightRepo;
import com.swastikairhub.SwastiKAirHubBackend.Domain.FlightTicket;
import com.swastikairhub.SwastiKAirHubBackend.DTO.FlightTicketDTO;
import com.swastikairhub.SwastiKAirHubBackend.Repositories.FlightTicketRepo;
import com.swastikairhub.SwastiKAirHubBackend.Service.FlightTicketService;
import com.swastikairhub.SwastiKAirHubBackend.Domain.Ticket;
import com.swastikairhub.SwastiKAirHubBackend.Repositories.TicketRepo;
import com.swastikairhub.SwastiKAirHubBackend.Request.FlightTicketRequest;
import com.swastikairhub.SwastiKAirHubBackend.Util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightTicketServiceImpl implements FlightTicketService {
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
        checkValidation(request);
        FlightTicket flightTicket=toFlight(request);
        FlightTicket savedFlightTicket=repo.save(flightTicket);
        return toFlightTicketDTO(savedFlightTicket);
    }

    private void checkValidation(FlightTicketRequest request) {
        Ticket ticket=ticketRepo.findByTicketCode(request.getTicketCode());
        FlightDetail detail=flightRepo.findByFlightCode(request.getFlightCode());
        FlightTicket flightTicket=repo.findFlightTicket(detail,ticket);
        if (flightTicket!=null)
            throw new CustomException(CustomException.Type.TICKET_FOR_FLIGHT_ALREARY_EXISTS);
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
