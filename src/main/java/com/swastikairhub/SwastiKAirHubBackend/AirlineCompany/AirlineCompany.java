package com.swastikairhub.SwastiKAirHubBackend.AirlineCompany;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "airline_company")
public class AirlineCompany {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "airline_company_id")
    private String id;
    public String name;
    public String address;
    public String email;
    public String phoneNumber;
    public String contractDate;
    public String contractStatus;
}
