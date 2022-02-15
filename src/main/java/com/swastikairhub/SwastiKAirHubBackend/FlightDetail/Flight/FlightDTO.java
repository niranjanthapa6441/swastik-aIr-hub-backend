package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight;

import com.FYP.Sector.*;
import lombok.Builder;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
@Builder
public class FlightDTO {
    private String flightCode;
    private Date departureDate;
    private Time departureTime;
    private Sector sector;
}
