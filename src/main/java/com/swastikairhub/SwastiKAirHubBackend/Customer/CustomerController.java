package com.swastikairhub.SwastiKAirHubBackend.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping
    public Iterable<Customer> findAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public CustomerDTO findById(@PathVariable String id){
        return service.findById(id);
    }
    @PostMapping
    public CustomerDTO save(@RequestBody CustomerRequest request){
        return service.save(request);
    }
    @PutMapping("/{id}")
    public CustomerDTO update(@PathVariable String id,@RequestBody CustomerRequest request){
        return service.update(id,request);
    }
    @DeleteMapping("/{id}")
    public CustomerDTO delete(@PathVariable String id){
        return service.delete(id);
    }

}
