package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight;

import lombok.Data;

import java.util.Date;

@Data
public class SearchFlightRequest {
    private String sector;
    private Date departureDate;
    private Date arrivalDate;
    private String nationality;
    private String numberOfTraveller;
}
