package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Passenger.Passenger;
import com.swastikairhub.SwastiKAirHubBackend.User.User;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket.FlightTicket;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookingDTO {
    private String id;
    private FlightTicket flightTicket;
    private User customer;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String bookingDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private String bookingTime;
    private String numberOfTraveller;
    private int totalPrice;
    private String status;
    private List<Passenger> passengerList;
}
