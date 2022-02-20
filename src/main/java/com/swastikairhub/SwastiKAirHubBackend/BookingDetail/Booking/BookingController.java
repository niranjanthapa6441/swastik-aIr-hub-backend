package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking;

import com.swastikairhub.SwastiKAirHubBackend.Util.RestResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService service;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return RestResponse.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody BookingRequest request) {
        return RestResponse.ok(service.save(request),"Booking Details Saved");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @Valid @RequestBody BookingRequest request) {
        return RestResponse.ok(service.update(id, request),"Booking Details Updated");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        return RestResponse.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        return RestResponse.ok(service.delete(id),"Booking Details Cancelled");
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Object> findByCustomerId(@PathVariable String id) {
        return RestResponse.ok(service.findByCustomerId(id));
    }
}
