package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket;

import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket.BaggagePolicy.BaggagePolicy;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket.CancellationPolicy.CancellationPolicy;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDTO {
    private String ticketCode;
    private String price;
    private String Status;
    private CancellationPolicy cancellationPolicy;
    private BaggagePolicy baggagePolicy;

}