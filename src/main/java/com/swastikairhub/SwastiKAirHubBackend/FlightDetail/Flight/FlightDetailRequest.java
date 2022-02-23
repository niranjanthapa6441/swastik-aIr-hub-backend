package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.swastikairhub.SwastiKAirHubBackend.AirlineCompany.AirlineCompany;
import com.swastikairhub.SwastiKAirHubBackend.AirlineCompany.AirlineCompanyRequest;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector.Sector;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector.SectorRequest;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class FlightDetailRequest {
    @NotBlank( message = "The flight code should not be empty")
    private String flightCode;
    @NotBlank( message = "The departure date should not be empty")
    private String departureDate;
    @NotBlank( message = "The departure time should not be empty")
    private String departureTime;
    @NotBlank( message = "The status should not be empty")
    private String status;
    @NotBlank( message = "The sector code should not be empty")
    private String sectorCode;
    @NotBlank( message = "The company name should not be empty")
    private String companyName;
}
