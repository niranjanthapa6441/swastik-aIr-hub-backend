package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.swastikairhub.SwastiKAirHubBackend.AirlineCompany.AirlineCompany;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector.Sector;
import lombok.Builder;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
@Builder
public class FlightDTO {
    private String id;
    private String flightCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String departureDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private String departureTime;
    private Sector sector;
    private AirlineCompany company;
    private String status;
}
