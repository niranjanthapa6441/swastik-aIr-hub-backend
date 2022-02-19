package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight;

import lombok.Data;

import java.util.Date;

@Data
public class SearchFlightRequest {
    private String sectorCode;
    private String departureDate;
    private String arrivalDate;
    private String nationality;
    private String numberOfTraveller;
}
