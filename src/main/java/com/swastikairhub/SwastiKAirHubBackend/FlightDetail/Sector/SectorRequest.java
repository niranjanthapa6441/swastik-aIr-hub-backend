package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector;

import lombok.Data;

@Data
public class SectorRequest {
    private String sectorCode;
    private String from;
    private String to;
    private String duration;
    private String status;
}
