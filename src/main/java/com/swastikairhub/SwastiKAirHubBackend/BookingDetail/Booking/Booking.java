package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking;

import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket.FlightTicket;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "booking_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "flight_ticket_id")
    private FlightTicket flightTicket;


}
