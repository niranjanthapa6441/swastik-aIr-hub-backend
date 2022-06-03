package com.swastikairhub.SwastiKAirHubBackend.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
