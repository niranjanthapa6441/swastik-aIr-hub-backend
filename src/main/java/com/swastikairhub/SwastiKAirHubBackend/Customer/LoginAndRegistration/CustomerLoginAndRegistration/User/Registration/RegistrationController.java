package com.swastikairhub.SwastiKAirHubBackend.Customer.LoginAndRegistration.CustomerLoginAndRegistration.User.Registration;

import com.swastikairhub.SwastiKAirHubBackend.Customer.LoginAndRegistration.CustomerLoginAndRegistration.User.Registration.RegistrationToken.Status;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest registrationRequest){
         return registrationService.register(registrationRequest);
    }
    @GetMapping(path = "/register/confirm")
    public Status confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
