package com.swastikairhub.SwastiKAirHubBackend.AirlineCompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class AirlineCompanyController {
    @Autowired
    private AirlineCompanyService service;

    @GetMapping
    public Iterable<AirlineCompany> getAll(){
        return service.findAll();
    }
    @PostMapping
    public AirlineDTO addCompany(@RequestBody AirlineCompanyRequest request){
        return  service.save(request);

    }
    @GetMapping("/{id}")
    public AirlineDTO getCompanyById(@PathVariable String id){
        return service.findById(id);
    }
    @PutMapping("/{id}")
    public AirlineDTO update(@PathVariable String id, @RequestBody AirlineCompanyRequest request){
        return service.update(id,request);
    }
    @DeleteMapping("/{id}")
    public AirlineDTO delete(@PathVariable String id){
        return service.delete(id);
    }
}
