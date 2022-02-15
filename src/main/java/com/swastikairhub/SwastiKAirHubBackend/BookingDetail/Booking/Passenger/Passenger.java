package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Passenger;

import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Booking;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "passenger_id")
    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
