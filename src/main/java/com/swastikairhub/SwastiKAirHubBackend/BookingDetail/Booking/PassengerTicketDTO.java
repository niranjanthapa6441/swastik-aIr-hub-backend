package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class PassengerTicketDTO {
private String departure;
private String arrival;
private String passengerName;
private String flightCode;
private LocalDate departureDate;
private String departureTime;
private String ticketNumber;
private int ticketPrice;
private String sectorCode;
}
