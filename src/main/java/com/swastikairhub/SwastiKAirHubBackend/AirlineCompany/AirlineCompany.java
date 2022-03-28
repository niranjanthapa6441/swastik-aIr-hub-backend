package com.swastikairhub.SwastiKAirHubBackend.AirlineCompany;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "airline_company")
public class AirlineCompany {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "airline_company_id")
    private String id;


    @Column(unique = true,nullable = false)
    public String name;

    @Column(nullable = false)
    public String address;

    @Column(unique = true,nullable = false)
    public String email;


    @Column(unique = true,nullable = false,length = 10)
    public String phoneNumber;

    @Column(nullable = false)
    public String contractDate;

    @Column(nullable = false)
    public String contractStatus;
}
