package com.swastikairhub.SwastiKAirHubBackend.Customer;

import lombok.Data;

@Data
public class CustomerRequest {
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phoneNumber;
}
