package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight;

import com.swastikairhub.SwastiKAirHubBackend.Util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService service;

    @GetMapping
    public ResponseEntity<Object> findAll(){
        return RestResponse.ok(service.findAll());
    }
    @GetMapping("/{flightCode}")
    public ResponseEntity<Object> findById(@PathVariable String flightCode){
        return  RestResponse.ok(service.findByFlightCode(flightCode));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id,@Valid @RequestBody FlightDetailRequest request){
        return RestResponse.ok(service.update(id,request),"Flight Details Updated");
    }
    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody FlightDetailRequest request){
        return RestResponse.ok(service.save(request),"FLight Details Saved");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        return RestResponse.ok(service.delete(id),"Flight Details Saved");
    }

    @PostMapping("/searchFlights")
    public ResponseEntity<Object> findAvailableFlights(@Valid @RequestBody SearchFlightRequest request){
        return RestResponse.ok(service.searchFlight(request),"Found FLights");
    }
}
