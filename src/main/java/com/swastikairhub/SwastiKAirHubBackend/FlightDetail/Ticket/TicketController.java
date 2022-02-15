package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public Iterable<Ticket> findAll() {
        return ticketService.findAll();
    }

    @PostMapping
    public TicketDTO save(@RequestBody TicketRequest request) {
        return ticketService.save(request);
    }

    @PutMapping("/{id}")
    public TicketDTO update(@PathVariable int id,@RequestBody TicketRequest request) {
        return ticketService.update(id, request);
    }
    @GetMapping("/{id}")
    public TicketDTO update(@PathVariable int id){
        return ticketService.findTicketByID(id);
    }
    @DeleteMapping("/{id}")
    public TicketDTO delete(@PathVariable int id){
        return ticketService.delete(id);
    }
}
