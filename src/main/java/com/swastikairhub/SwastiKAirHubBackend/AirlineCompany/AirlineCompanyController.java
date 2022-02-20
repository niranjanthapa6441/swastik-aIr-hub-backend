package com.swastikairhub.SwastiKAirHubBackend.AirlineCompany;

import com.swastikairhub.SwastiKAirHubBackend.Util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/company")
public class AirlineCompanyController {
    @Autowired
    private AirlineCompanyService service;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return RestResponse.ok(service.findAll());
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addCompany(@Valid @RequestBody AirlineCompanyRequest request){
        return RestResponse.ok(service.save(request),"Company Added Successfully");

    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCompanyById(@PathVariable String id){
        return RestResponse.ok(service.findById(id),"Company By Id found");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @Valid @RequestBody AirlineCompanyRequest request){
        return RestResponse.ok(service.update(id,request),"Company Details Updated");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        return RestResponse.ok(service.delete(id),"Company Details Deleted");
    }
}
