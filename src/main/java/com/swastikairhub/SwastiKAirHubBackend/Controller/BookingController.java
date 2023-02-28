package com.swastikairhub.SwastiKAirHubBackend.Controller;

import com.swastikairhub.SwastiKAirHubBackend.Service.BookingService;
import com.swastikairhub.SwastiKAirHubBackend.Request.BookingRequest;
import com.swastikairhub.SwastiKAirHubBackend.Util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAll() {
        return RestResponse.ok(service.findAll());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@Valid @RequestBody BookingRequest request) {
        return RestResponse.ok(service.save(request),"Booking Details Saved");
    }
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@PathVariable String id, @Valid @RequestBody BookingRequest request) {
        return RestResponse.ok(service.update(id, request),"Booking Details Updated");
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable String id) {
        return RestResponse.ok(service.findById(id));
    }

    @DeleteMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delete(@PathVariable String id) {
        return RestResponse.ok(service.delete(id),"Booking Details Cancelled");
    }

    @GetMapping(value = "/customer/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByCustomerId(@PathVariable String id,
                                                   @RequestParam int page,
                                                   @RequestParam int size) {
        return RestResponse.ok(service.findByCustomerId(id, page,size));
    }
    @GetMapping(value = "/customer/ticket/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findTickets(@PathVariable String id) {
        return RestResponse.ok(service.findTicketByBookingId(id));
    }
}
