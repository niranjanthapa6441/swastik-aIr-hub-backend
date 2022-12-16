package com.swastikairhub.SwastiKAirHubBackend.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AirlineDTO {
    private String id;
    public String name;
    public String address;
    public String email;
    public String phoneNumber;
    public String contractDate;
    public String contractStatus;
}
