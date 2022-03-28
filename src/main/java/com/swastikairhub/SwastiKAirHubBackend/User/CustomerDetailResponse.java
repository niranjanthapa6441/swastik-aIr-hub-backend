package com.swastikairhub.SwastiKAirHubBackend.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDetailResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phoneNumber;
}
