package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket;

import lombok.Data;

@Data
public class FlightTicketRequest {
    private String ticketCode;
    private String flightCode;
}
