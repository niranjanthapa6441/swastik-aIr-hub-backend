package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sector")
public class Sector {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name="sector_id")
    private String id;
    @Column(name = "sector_code",nullable = false,unique = true)
    private String sectorCode;
    @Column(name="take_off_from",nullable = false)
    private String from;
    @Column(name="landing_to",nullable = false)
    private String to;
    @Column(nullable = false)
    private String duration;
    @Column(nullable = false)
    private String status;
}
