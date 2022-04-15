package com.swastikairhub.SwastiKAirHubBackend.PaymentDetail;

import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Booking;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket.FlightTicket;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
@Entity
@Data
@Table(name = "payment_details")
public class Payment {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
    @Column(name = "total_amount")
    private int totalAmount;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "payment_date")
    private LocalDate paymentDate;
    @Column(name = "payment_time")
    private LocalTime paymentTIme;
    @Column(name = "paid_via")
    private String paidVia;
    @Column(name = "status")
    private String status;
}
