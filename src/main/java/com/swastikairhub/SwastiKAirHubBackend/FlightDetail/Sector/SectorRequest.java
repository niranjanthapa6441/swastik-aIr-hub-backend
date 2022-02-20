package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SectorRequest {
    @NotBlank(message = "The sector code should not be empty")
    private String sectorCode;
    @NotBlank(message = "The from  should not be empty")
    private String from;
    @NotBlank(message = "The destination code should not be empty")
    private String to;
    @NotBlank(message = "The duration code should not be empty")
    private String duration;
    @NotBlank(message = "The status should not be empty")
    private String status;
}
