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
    private String sectorName;
    @Column(name="take_off_from")
    private String from;
    @Column(name="landing_to")
    private String to;
    private String duration;
    private String status;
}
