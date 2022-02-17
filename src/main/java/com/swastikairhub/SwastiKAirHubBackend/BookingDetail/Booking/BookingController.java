package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private  BookingService service;

    @GetMapping
    public Iterable<Booking> findAll(){
        return service.findAll();
    }
    @PutMapping
    public BookingDTO save(@RequestBody BookingRequest request){
        return service.save(request);
    }
    @PutMapping("/{id}")
    public BookingDTO update(@PathVariable String id,@RequestBody BookingRequest request){
        return service.update(id,request);
    }
    @GetMapping("/{id}")
    public BookingDTO findById(@PathVariable String id){
        return service.findById(id);
    }
    @DeleteMapping("/{id}")
    public BookingDTO delete(@PathVariable String id){
        return service.delete(id);
    }
    @GetMapping("/customer/{id}")
    public Iterable<Booking> findByCustomerId(@PathVariable String id){
        return service.findByCustomerId(id);
    }
}
