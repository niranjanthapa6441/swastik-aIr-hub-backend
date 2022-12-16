package com.swastikairhub.SwastiKAirHubBackend.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PassengerDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
}
