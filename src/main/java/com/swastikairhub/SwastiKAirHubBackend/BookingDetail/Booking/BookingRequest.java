package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking;

import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Passenger.Passenger;
import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Passenger.PassengerRequest;
import com.swastikairhub.SwastiKAirHubBackend.Customer.Customer;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket.FlightTicket;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
public class BookingRequest {
    private String flightCode;
    private String ticketCode;
    private String customerId;
    private int numberOfTraveller;
    private String status;
    private List<PassengerRequest> passengerList;
}
