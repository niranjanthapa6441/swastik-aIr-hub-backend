package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight;

import com.swastikairhub.SwastiKAirHubBackend.AirlineCompany.AirlineCompany;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector.Sector;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


@Data
@Entity
@Table(name = "flight")
public class FlightDetail {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "flight_code",nullable = false,unique = true)
    private String flightCode;

    @Column(name = "departure_date",nullable = false)
    private LocalDate departureDate;

    @Column(name = "departure_time",nullable = false)
    private LocalTime departureTime;

    @Column(name = "status",nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @ManyToOne
    @JoinColumn
    private AirlineCompany Company;

}
