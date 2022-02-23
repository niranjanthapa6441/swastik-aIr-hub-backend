package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking;

import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Passenger.Passenger;
import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Passenger.PassengerRequest;
import com.swastikairhub.SwastiKAirHubBackend.Customer.Customer;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket.FlightTicket;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
public class BookingRequest {
    @NotBlank(message = "The flight code should not be empty")
    private String flightCode;
    @NotBlank(message = "The ticket code should not be empty")
    private String ticketCode;
    @NotBlank(message = "The customer id should not be empty")
    private String customerId;
    private int numberOfTraveller;
    @NotBlank(message = "The status should not be empty")
    private String status;
    private List<PassengerRequest> passengerList;
}
