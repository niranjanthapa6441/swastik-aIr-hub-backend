package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket;

import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight.FlightDetail;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket.Ticket;

import java.util.List;

public class FlightTicketDTO {
    private String id;
    private List<Ticket> ticket;
    private FlightDetail flightDetail;
}
