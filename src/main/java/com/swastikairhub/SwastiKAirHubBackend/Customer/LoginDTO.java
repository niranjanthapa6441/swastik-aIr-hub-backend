package com.swastikairhub.SwastiKAirHubBackend.Customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDTO {
    private String username;
    private String customerId;
}
