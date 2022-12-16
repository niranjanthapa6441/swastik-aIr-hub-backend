package com.swastikairhub.SwastiKAirHubBackend.Request;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class SearchFlightRequest {
    @NotBlank(message = "the sector code should not be empty")
    private String sectorCode;
    @NotBlank(message = "the departure date should not be empty")
    private String departureDate;
    private String arrivalDate;
    private String nationality;
    @NotNull(message = "the number of  traveller should not be empty")
    private int numberOfTraveller;
}
