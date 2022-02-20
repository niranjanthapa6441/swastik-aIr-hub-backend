package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket;

import lombok.Data;

@Data
public class TicketRequest {
    private String ticketCode;
    private int price;
    private String Status;
}
