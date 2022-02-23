package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector;

import com.swastikairhub.SwastiKAirHubBackend.Util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sector")
public class SectorController {
    @Autowired
    private SectorService service;
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> save(@Valid @RequestBody SectorRequest request){
        return RestResponse.ok(service.save(request),"Sector Details Saved");
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> getAll(){
        return RestResponse.ok(service.findAll());
    }
    @GetMapping(value = "/{sector}",produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> findBySector(@PathVariable String sector){
        return RestResponse.ok(service.findBySector(sector));
    }
    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> update(@PathVariable String id,@Valid @RequestBody SectorRequest request){
        return RestResponse.ok(service.update(id,request),"Sector Details Updated");
    }
    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> update(@PathVariable String id){
        return RestResponse.ok(service.delete(id),"Sector Details Deleted");
    }
}
