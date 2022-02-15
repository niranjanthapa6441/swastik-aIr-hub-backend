package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking;

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

}
