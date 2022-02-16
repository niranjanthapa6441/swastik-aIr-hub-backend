package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private  BookingService service;

    @GetMapping
    private Iterable<Booking> findAll(){
        return service.findAll();
    }
    @GetMapping
    private BookingDTO save(@RequestBody BookingRequest request){
        return service.save(request);
    }
    @PutMapping("/{id}")
    private BookingDTO update(@PathVariable String id,@RequestBody BookingRequest request){
        return service.update(id,request);
    }
    @GetMapping("/{id}")
    private BookingDTO findById(@PathVariable String id){
        return service.findById(id);
    }
    @DeleteMapping("/{id}")
    private BookingDTO delete(@PathVariable String id){
        return service.delete(id);
    }
}
