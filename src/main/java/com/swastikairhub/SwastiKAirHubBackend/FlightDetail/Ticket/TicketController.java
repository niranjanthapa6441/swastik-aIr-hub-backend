package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket;

import com.swastikairhub.SwastiKAirHubBackend.Util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return RestResponse.ok(ticketService.findAll());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@Valid @RequestBody TicketRequest request) {
        return RestResponse.ok(ticketService.save(request),"Ticket Details Saved");
    }

    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@PathVariable int id,@Valid @RequestBody TicketRequest request) {
        return RestResponse.ok(ticketService.update(id, request),"Ticket Details Updated");
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findBYId(@PathVariable int id){
        return RestResponse.ok(ticketService.findTicketByID(id));
    }
    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delete(@PathVariable int id){
        return RestResponse.ok(ticketService.delete(id),"Ticket Details deleted");
    }
}
