package com.swastikairhub.SwastiKAirHubBackend.Controller;

import com.swastikairhub.SwastiKAirHubBackend.Request.LoginRequest;
import com.swastikairhub.SwastiKAirHubBackend.Request.SignUpRequest;
import com.swastikairhub.SwastiKAirHubBackend.Request.UpdateProfileRequest;
import com.swastikairhub.SwastiKAirHubBackend.Service.RegistrationService;
import com.swastikairhub.SwastiKAirHubBackend.Service.UserService;
import com.swastikairhub.SwastiKAirHubBackend.User.Registration.RegistrationToken.Status;
import com.swastikairhub.SwastiKAirHubBackend.Util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class UserController {
    @Autowired
    private UserService service;
@Autowired
private RegistrationService registrationService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAll(){
        return RestResponse.ok(service.findAll());
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable String id){
        return RestResponse.ok(service.findById(id));
    }
    /*@PostMapping(value = "/register",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@Valid @RequestBody SignUpRequest request){
        return RestResponse.ok(service.save(request));
    }*/
    @PostMapping(value = "/register",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@Valid @RequestBody SignUpRequest request){
        System.out.println("Login insider");
        return RestResponse.ok(registrationService.register(request));
    }
    @GetMapping(path = "/register/confirm")
    public Status confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
    @PostMapping(value = "/loginresource",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> login(@Valid @RequestBody LoginRequest request){
        System.out.println("LOgin insider");
        return RestResponse.ok(service.login(request));
    }
    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@PathVariable String id, @Valid @RequestBody UpdateProfileRequest request){

        return RestResponse.ok(service.update(id,request));
    }
    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delete(@PathVariable String id){
        return RestResponse.ok(service.delete(id));
    }
    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
       return RestResponse.ok(service.logout());
    }
}
