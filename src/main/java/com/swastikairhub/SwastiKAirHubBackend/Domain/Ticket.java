package com.swastikairhub.SwastiKAirHubBackend.Domain;

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
    @Column(name = "ticket_code",nullable = false,unique = true)
    private String ticketCode;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private String Status;
}
