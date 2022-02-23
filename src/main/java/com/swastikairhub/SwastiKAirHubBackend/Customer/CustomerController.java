package com.swastikairhub.SwastiKAirHubBackend.Customer;

import com.swastikairhub.SwastiKAirHubBackend.Util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAll(){
        return RestResponse.ok(service.findAll());
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO findById(@PathVariable String id){
        return service.findById(id);
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO save(@Valid @RequestBody CustomerRequest request){
        return service.save(request);
    }
    @PostMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> login(@Valid @RequestBody LoginRequest request){
        return RestResponse.ok(service.login(request));
    }
    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO update(@PathVariable String id,@Valid @RequestBody CustomerRequest request){
        return service.update(id,request);
    }
    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO delete(@PathVariable String id){
        return service.delete(id);
    }

}
