package com.swastikairhub.SwastiKAirHubBackend.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.swastikairhub.SwastiKAirHubBackend.Domain.AirlineCompany;
import com.swastikairhub.SwastiKAirHubBackend.Domain.Sector;
import lombok.Builder;
import lombok.Data;

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
