package com.swastikairhub.SwastiKAirHubBackend.AirlineCompany;

import lombok.Data;

import javax.annotation.RegEx;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AirlineCompanyRequest {
    @Size(min = 4,max =12)
    @NotBlank(message = "The company name should not be empty")
    public String name;
    @NotBlank(message = "The address number should not be empty")
    public String address;
    @NotBlank(message = "The phone number should not be empty")
    @Email(message = "The Valid Email must be passed")
    public String email;
    @Digits(message = "The phone number should contain digits", integer = 10, fraction = 0)
    @NotBlank(message = "The phone number should not be empty")
    @Size(min = 10,max = 10,message = "The PhoneNUmber Should Consists of 10 digits")
    public String phoneNumber;
    @NotBlank(message = "Contract Date must not be empty")
    public String contractDate;
    @NotBlank(message = "Contract Status must not be empty")
    public String contractStatus;
}
