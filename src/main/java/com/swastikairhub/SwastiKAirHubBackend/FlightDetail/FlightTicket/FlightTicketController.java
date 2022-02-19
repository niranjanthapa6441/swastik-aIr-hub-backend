package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight/flightTickets")
public class FlightTicketController {
    @Autowired
    FlightTicketService service;
    @GetMapping
    public Iterable<FlightTicket> findAll(){
        return service.findAll();
    }
    @PostMapping
    public FlightTicketDTO save(@RequestBody FlightTicketRequest request){
        return  service.save(request);
    }
}
