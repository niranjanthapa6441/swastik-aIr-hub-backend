package com.swastikairhub.SwastiKAirHubBackend.Request;

import lombok.Data;

@Data
public class FlightTicketRequest {
    private String ticketCode;
    private String flightCode;
}
