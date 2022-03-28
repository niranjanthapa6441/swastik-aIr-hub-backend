package com.swastikairhub.SwastiKAirHubBackend.User;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class SignUpRequest {
    @NotBlank(message = "First Name should not be empty")
    private String firstName;
    @NotBlank(message = "last Name should not be empty")
    private String lastName;
    private String middleName;
    @Email
    @NotBlank(message = "Email should not be empty")
    private String email;
    @NotBlank(message = "Email should not be empty")
    private String phoneNumber;
    @NotBlank(message = "Username should not be empty")
    private String username;
    @Size(min = 8)
    @Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",message = "password field must contain characters")
    @NotBlank(message = "Password should not be empty")
    private String password;
}
