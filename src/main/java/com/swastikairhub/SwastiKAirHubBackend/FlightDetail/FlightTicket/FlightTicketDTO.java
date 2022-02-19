package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket;

import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight.FlightDetail;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket.Ticket;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class FlightTicketDTO {
    private String id;
    private Ticket ticket;
    private FlightDetail flightDetail;
}
