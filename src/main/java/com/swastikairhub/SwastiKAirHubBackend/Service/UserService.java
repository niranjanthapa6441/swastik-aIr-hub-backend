package com.swastikairhub.SwastiKAirHubBackend.Service;

import com.swastikairhub.SwastiKAirHubBackend.ServiceImpl.LoginDTO;
import com.swastikairhub.SwastiKAirHubBackend.Request.LoginRequest;
import com.swastikairhub.SwastiKAirHubBackend.Request.SignUpRequest;
import com.swastikairhub.SwastiKAirHubBackend.Request.UpdateProfileRequest;
import com.swastikairhub.SwastiKAirHubBackend.User.CustomerDetailResponse;
import com.swastikairhub.SwastiKAirHubBackend.User.MessageResponse;
import com.swastikairhub.SwastiKAirHubBackend.User.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String save(SignUpRequest request);
    Iterable<User> findAll();
    User update(String id, UpdateProfileRequest request);
    String delete(String id);
    CustomerDetailResponse findById(String id);
    LoginDTO login(LoginRequest request);
    public int enableAppUser(String email);

    public ResponseEntity<MessageResponse> logout();
}
