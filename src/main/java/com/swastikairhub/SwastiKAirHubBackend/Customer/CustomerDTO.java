package com.swastikairhub.SwastiKAirHubBackend.Customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phoneNumber;
}
