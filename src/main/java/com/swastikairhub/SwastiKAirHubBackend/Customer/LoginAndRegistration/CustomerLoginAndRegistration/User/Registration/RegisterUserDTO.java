package com.swastikairhub.SwastiKAirHubBackend.Customer.LoginAndRegistration.CustomerLoginAndRegistration.User.Registration;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUserDTO {
    private int userId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Boolean locked;
    private Boolean enabled;
}
