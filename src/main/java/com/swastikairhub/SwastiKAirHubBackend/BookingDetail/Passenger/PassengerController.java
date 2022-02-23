package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public Iterable<Passenger> getAll(){
        return passengerService.findAll();
    }
}
