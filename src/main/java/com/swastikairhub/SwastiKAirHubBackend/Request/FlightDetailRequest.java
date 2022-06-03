package com.swastikairhub.SwastiKAirHubBackend.Request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotNull( message = "The avaiilable seats should not be empty")
    private int availableSeats;
}
