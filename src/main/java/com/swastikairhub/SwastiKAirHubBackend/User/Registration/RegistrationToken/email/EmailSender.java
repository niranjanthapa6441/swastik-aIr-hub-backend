package com.swastikairhub.SwastiKAirHubBackend.User.Registration.RegistrationToken.email;

public interface EmailSender {
    void send(String to, String email);
}
