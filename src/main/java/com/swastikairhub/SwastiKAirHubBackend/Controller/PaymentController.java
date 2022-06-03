package com.swastikairhub.SwastiKAirHubBackend.Controller;

import com.swastikairhub.SwastiKAirHubBackend.Service.PaymentService;
import com.swastikairhub.SwastiKAirHubBackend.Util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService service;
    @GetMapping(value = "/customer/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByCustomerId(@PathVariable String id) {
        return RestResponse.ok(service.findPaymentByCustomerID(id));
    }
}
