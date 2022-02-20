package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket;

import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket.BaggagePolicy.BaggagePolicy;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket.CancellationPolicy.CancellationPolicy;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDTO {
    private int id;
    private String ticketCode;
    private int price;
    private String Status;
    private CancellationPolicy cancellationPolicy;
    private BaggagePolicy baggagePolicy;

}
