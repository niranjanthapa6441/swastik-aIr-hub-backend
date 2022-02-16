package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking;

import com.swastikairhub.SwastiKAirHubBackend.Customer.Customer;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket.FlightTicket;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;
import java.util.Date;
@Data
@Builder
public class BookingDTO {
    private String id;
    private FlightTicket flightTicket;
    private Customer customer;
    private Date bookingDate;
    private Time bookingTime;
    private String status;
}
