package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket;

import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight.FlightDetail;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket.Ticket;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Data
@Entity
@Table(name = "flight_ticket")
public class FlightTicket {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "flight_ticket_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightDetail detail;

}
