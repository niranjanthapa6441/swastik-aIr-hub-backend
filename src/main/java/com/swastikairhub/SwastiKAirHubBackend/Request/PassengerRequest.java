package com.swastikairhub.SwastiKAirHubBackend.Request;

import lombok.Data;

@Data
public class PassengerRequest {
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
}
