package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight;

import com.swastikairhub.SwastiKAirHubBackend.AirlineCompany.AirlineCompany;
import com.swastikairhub.SwastiKAirHubBackend.AirlineCompany.AirlineCompanyRequest;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector.Sector;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector.SectorRequest;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class FlightDetailRequest {
    private String flightCode;
    private Date departureDate;
    private String departureTime;
    private String status;
    private String sector;
    private String companyName;
}
