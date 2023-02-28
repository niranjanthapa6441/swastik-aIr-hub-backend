package com.swastikairhub.SwastiKAirHubBackend.Request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class SearchFlightRequest {
    @NotBlank(message = "the sector code not be empty")
    private String sectorCode;
    @NotBlank(message = "the departure date should not be empty")
    private String departureDate;
    private String arrivalDate;
    private String nationality;
    @NotNull(message = "the number of  traveller should not be empty")
    private int numberOfTraveller;
}
