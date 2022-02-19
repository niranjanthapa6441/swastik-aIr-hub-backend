package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Passenger;

import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking.Booking;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Data
public class PassengerRequest {
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
}
