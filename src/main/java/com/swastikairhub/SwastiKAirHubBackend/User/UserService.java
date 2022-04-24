package com.swastikairhub.SwastiKAirHubBackend.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String save(SignUpRequest request);
    Iterable<User> findAll();
    User update(String id,UpdateProfileRequest request);
    String delete(String id);
    CustomerDetailResponse findById(String id);
    LoginDTO login(LoginRequest request);
}
