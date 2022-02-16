package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/sector")
public class SectorController {
    @Autowired
    private SectorService service;
    @PostMapping
    private SectorDTO save(@RequestBody SectorRequest request){
        return service.save(request);
    }
    @GetMapping
    private Iterable<Sector> getAll(){
        return service.findAll();
    }
    @GetMapping("/{sector}")
    private SectorDTO findBySector(@PathVariable String sector){
        return service.findBySector(sector);
    }
    @PutMapping("/{id}")
    private SectorDTO update(@PathVariable String id,@RequestBody SectorRequest request){
        return service.update(id,request);
    }
    @DeleteMapping("/{id}")
    private SectorDTO update(@PathVariable String id){
        return service.delete(id);
    }
}
