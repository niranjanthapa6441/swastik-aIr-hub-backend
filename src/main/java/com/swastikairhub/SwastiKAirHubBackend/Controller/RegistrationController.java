package com.swastikairhub.SwastiKAirHubBackend.Controller;

import com.swastikairhub.SwastiKAirHubBackend.Service.RegistrationService;
import com.swastikairhub.SwastiKAirHubBackend.User.Registration.RegistrationToken.Status;
import com.swastikairhub.SwastiKAirHubBackend.Request.SignUpRequest;
import com.swastikairhub.SwastiKAirHubBackend.Service.UserService;
import com.swastikairhub.SwastiKAirHubBackend.Util.RestResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("customer")
public class RegistrationController {
    private final UserService userService;
    private final RegistrationService registrationService;

    public RegistrationController(UserService userService, RegistrationService registrationService) {
        this.userService = userService;
        this.registrationService = registrationService;
    }

}
