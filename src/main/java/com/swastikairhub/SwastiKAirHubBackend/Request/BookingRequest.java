package com.swastikairhub.SwastiKAirHubBackend.Request;

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
    private int  totalTicketPrice;
    private List<PassengerRequest> passengerList;
    private  String paymentMethod;
    private String paymentStatus;
    private String paidVia;
    private int paidAmount;
}
