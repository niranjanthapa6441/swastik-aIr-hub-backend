package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking;

import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Passenger.PassengerRequest;
import lombok.Data;

import javax.validation.constraints.NotBlank;
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
