package com.swastikairhub.SwastiKAirHubBackend.DTO;

import com.swastikairhub.SwastiKAirHubBackend.Domain.FlightDetail;
import com.swastikairhub.SwastiKAirHubBackend.Domain.Ticket;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightTicketDTO {
    private String id;
    private Ticket ticket;
    private FlightDetail flightDetail;
}
