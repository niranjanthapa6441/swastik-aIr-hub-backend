package com.swastikairhub.SwastiKAirHubBackend.Customer.LoginAndRegistration.CustomerLoginAndRegistration.User;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User validateUser(User user);

    public String registerUser(User user);

    public Iterable<User> findAllUser();
    public int enableAppUser(String email);
}
