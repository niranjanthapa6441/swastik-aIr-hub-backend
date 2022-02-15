package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class FlightRequest {
    private String flightCode;
    private Date departureDate;
    private Time departureTime;
    private String sector;
}
