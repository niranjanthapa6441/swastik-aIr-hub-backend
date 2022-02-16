package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService service;

    @GetMapping
    public Iterable<FlightDetail> findAll(){
        return service.findAll();
    }
    @GetMapping("/{flightCode}")
    public FlightDTO findById(@PathVariable String flightCode){
        return  service.findByFlightCode(flightCode);
    }
    @PutMapping("/{id}")
    public FlightDTO update(@PathVariable String id, @RequestBody FlightDetailRequest request){
        return service.update(id,request);
    }
    @PostMapping
    public FlightDTO save(@RequestBody FlightDetailRequest request){
        return service.save(request);
    }
    @DeleteMapping("/{id}")
    public FlightDTO delete(@PathVariable String id){
        return service.delete(id);
    }

}
