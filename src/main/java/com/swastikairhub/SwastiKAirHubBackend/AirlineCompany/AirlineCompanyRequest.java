package com.swastikairhub.SwastiKAirHubBackend.AirlineCompany;

import lombok.Data;

@Data
public class AirlineCompanyRequest {
    public String name;
    public String address;
    public String email;
    public String phoneNumber;
    public String contractDate;
    public String contractStatus;
}
