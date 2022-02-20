package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TicketRequest {
    @NotBlank(message = "The ticket code should not be emoty")
    private String ticketCode;
    @NotBlank(message = "The ticket price should not be empty")
    private int price;
    @NotBlank(message = "The Status should not be empty")
    private String Status;
}
