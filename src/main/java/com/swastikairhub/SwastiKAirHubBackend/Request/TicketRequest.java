package com.swastikairhub.SwastiKAirHubBackend.Request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TicketRequest {
    @NotBlank(message = "The ticket code should not be emoty")
    private String ticketCode;
    private int price;
    @NotBlank(message = "The Status should not be empty")
    private String Status;
}
