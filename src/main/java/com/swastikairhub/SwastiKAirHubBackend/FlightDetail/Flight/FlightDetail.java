package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight;

import com.swastikairhub.SwastiKAirHubBackend.AirlineCompany.AirlineCompany;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector.Sector;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;


@Data
@Entity
@Table(name = "flight")
public class FlightDetail {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "flight_code")
    private String flightCode;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @ManyToOne
    @JoinColumn
    private AirlineCompany Company;

}
