package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="ticket")
public class Ticket {
    @SequenceGenerator(
            name = "ticket_id_seq",
            sequenceName = "ticket_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="ticket_sequence"
    )
    private int id;
    private String ticketCode;
    private String price;
    private String Status;
}
