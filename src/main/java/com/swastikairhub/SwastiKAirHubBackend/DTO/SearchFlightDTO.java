package com.swastikairhub.SwastiKAirHubBackend.DTO;

import com.swastikairhub.SwastiKAirHubBackend.Domain.Sector;
import com.swastikairhub.SwastiKAirHubBackend.Domain.Ticket;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchFlightDTO {
    private String flightCode;
    private String departureDate;
    private String departureTime;
    private Sector sector;
    private String companyName;
    private String status;
    private Ticket ticket;
    //private List<Ticket> tickets;
}
