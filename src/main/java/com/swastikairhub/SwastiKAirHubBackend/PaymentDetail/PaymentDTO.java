package com.swastikairhub.SwastiKAirHubBackend.PaymentDetail;

import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Booking;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class PaymentDTO {
    private String id;
    private String bookingId;
    private int totalAmount;
    private String paymentMethod;
    private LocalDate paymentDate;
    private LocalTime paymentTIme;
    private String status;
}
