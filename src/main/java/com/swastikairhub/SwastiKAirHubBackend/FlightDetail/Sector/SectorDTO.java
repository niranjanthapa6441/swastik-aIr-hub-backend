package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SectorDTO {
    private String id;
    private String sectorCode;
    private String from;
    private String to;
    private String duration;
    private String status;
}
