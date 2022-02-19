package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight;

import com.swastikairhub.SwastiKAirHubBackend.AirlineCompany.AirlineCompany;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector.Sector;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket.Ticket;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class SearchFlightDTO {
    private String flightCode;
    private String departureDate;
    private String departureTime;
    private String sectorCode;
    private String companyName;
    private String status;
    private List<Ticket> tickets;
}
