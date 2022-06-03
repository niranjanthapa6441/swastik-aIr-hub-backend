package com.swastikairhub.SwastiKAirHubBackend.ServiceImpl;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDTO {
    private String username;
    private String customerId;
    private String type;
    private String accessToken;
}
