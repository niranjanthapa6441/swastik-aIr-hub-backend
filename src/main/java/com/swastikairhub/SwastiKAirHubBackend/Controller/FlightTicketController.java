package com.swastikairhub.SwastiKAirHubBackend.Controller;

import com.swastikairhub.SwastiKAirHubBackend.DTO.FlightTicketDTO;
import com.swastikairhub.SwastiKAirHubBackend.Domain.FlightTicket;
import com.swastikairhub.SwastiKAirHubBackend.Service.FlightTicketService;
import com.swastikairhub.SwastiKAirHubBackend.Request.FlightTicketRequest;
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
