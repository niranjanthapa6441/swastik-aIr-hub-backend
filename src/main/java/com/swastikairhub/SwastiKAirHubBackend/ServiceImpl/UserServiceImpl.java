package com.swastikairhub.SwastiKAirHubBackend.ServiceImpl;

import com.swastikairhub.SwastiKAirHubBackend.Repositories.UserRepo;
import com.swastikairhub.SwastiKAirHubBackend.Request.LoginRequest;
import com.swastikairhub.SwastiKAirHubBackend.Request.SignUpRequest;
import com.swastikairhub.SwastiKAirHubBackend.Request.UpdateProfileRequest;
import com.swastikairhub.SwastiKAirHubBackend.Role.ERole;
import com.swastikairhub.SwastiKAirHubBackend.Role.Role;
import com.swastikairhub.SwastiKAirHubBackend.Repositories.RoleRepository;
import com.swastikairhub.SwastiKAirHubBackend.Security.JWT.JWTUtils;
import com.swastikairhub.SwastiKAirHubBackend.Service.ConfirmationTokenService;
import com.swastikairhub.SwastiKAirHubBackend.Service.UserService;
import com.swastikairhub.SwastiKAirHubBackend.User.*;
import com.swastikairhub.SwastiKAirHubBackend.User.Registration.RegistrationToken.ConfirmationToken;
import com.swastikairhub.SwastiKAirHubBackend.Util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo repo;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private RoleRepository roleRepository;


    private final ConfirmationTokenService confirmationTokenService;


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTUtils jwtUtils;

    public UserServiceImpl(ConfirmationTokenService confirmationTokenService) {
        this.confirmationTokenService = confirmationTokenService;
    }

    @Override
    public String save(SignUpRequest request) {
        checkValidation(request);
        User customer = toCustomer(request);
        User saveCustomer = repo.save(customer);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                saveCustomer
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }
    @Override
    public int enableAppUser(String email) {
        Optional<User> findCustomer=repo.findCustomerByEmail(email);
        User updateCustomer=new User();
        Set<Role> roles = getRoles();
        if (findCustomer.isPresent()){
            User customer= findCustomer.get();
            updateCustomer.setId(customer.getId());
            updateCustomer.setFirstName(customer.getFirstName());
            updateCustomer.setEmail(customer.getEmail());
            updateCustomer.setLastName(customer.getLastName());
            updateCustomer.setMiddleName(customer.getMiddleName());
            updateCustomer.setPhoneNumber(customer.getPhoneNumber());
            updateCustomer.setUsername(customer.getUsername());
            updateCustomer.setPassword(customer.getPassword());
            updateCustomer.setEnabled(true);
            updateCustomer.setLocked(true);
            updateCustomer.setRoles(roles);
            updateCustomer.setStatus("Registered");
            repo.save(updateCustomer);
        }
        return 1;
    }
    @Override
    public LoginDTO login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return new LoginDTO(
                userDetails.getUsername(),
                userDetails.getId(),
                "Bearer",
                jwt
        );
    }
    @Override
    public User update(String id, UpdateProfileRequest request) {
        Optional<User> findCustomer = repo.findById(id);
        checkUpdateValidation(request,findCustomer.get());
        if (findCustomer.isPresent()) {
            User updateCustomer = toUpdateCustomer(request,findCustomer.get());
            User updatedCustomer = repo.save(updateCustomer);
            return updatedCustomer;
        } else
            throw new NullPointerException("The customer does not exist");
    }

    @Override
    public String delete(String id) {
        Optional<User> findCustomer = repo.findById(id);
        if (findCustomer.isPresent()) {
            User deleteCustomer = findCustomer.get();
            deleteCustomer.setStatus("terminated");
            User deletedCustomer = repo.save(deleteCustomer);
            return "user deleted";
        } else
            throw new NullPointerException("The Customer Doesn't Exist");
    }

    @Override
    public CustomerDetailResponse findById(String id) {
        Optional<User> findCustomer = repo.findById(id);
        if (findCustomer.isPresent()) {
            User customer = findCustomer.get();
            return toCustomerDTO(customer);
        } else
            throw new NullPointerException("The Customer Doesn't Exist");
    }
    @Override
    public Iterable<User> findAll() {
        return repo.findAll();
    }
    private CustomerDetailResponse toCustomerDTO(User customer) {
        return CustomerDetailResponse.builder().
                id(customer.getId()).
                email(customer.getEmail()).
                firstName(customer.getFirstName()).
                lastName(customer.getLastName()).
                middleName(customer.getMiddleName()).
                phoneNumber(customer.getPhoneNumber()).
                build();
    }

    private User toCustomer(SignUpRequest request) {
        User customer=new User();
        Set<Role> roles = getRoles();
        customer.setFirstName(request.getFirstName());
        customer.setEmail(request.getEmail());
        customer.setLastName(request.getLastName());
        customer.setMiddleName(request.getMiddleName());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setUsername(request.getUsername());
        customer.setPassword(encoder.encode(request.getPassword()));
        customer.setRoles(roles);
        customer.setStatus("Registered");
        return customer;
    }
    private User toUpdateCustomer(UpdateProfileRequest request,User customer) {
        User updateCustomer=new User();
        Set<Role> roles = getRoles();
        updateCustomer.setId(customer.getId());
        updateCustomer.setFirstName(request.getFirstName());
        updateCustomer.setEmail(request.getEmail());
        updateCustomer.setLastName(request.getLastName());
        updateCustomer.setMiddleName(request.getMiddleName());
        updateCustomer.setPhoneNumber(request.getPhoneNumber());
        updateCustomer.setUsername(customer.getUsername());
        updateCustomer.setPassword(customer.getPassword());
        updateCustomer.setRoles(roles);
        updateCustomer.setStatus("Registered");
        return updateCustomer;
    }


    private Set<Role> getRoles() {
        Role role=roleRepository.findByName(ERole.ROLE_USER);
        Set<Role> roles= new HashSet<>();
        roles.add(role);
        return roles;
    }

    private void checkValidation(SignUpRequest request) {
        checkEmail(request);
        checkUsername(request);
        checkPhoneNumber(request);
    }
    private void checkUpdateValidation(UpdateProfileRequest request,User user) {
        checkUpdateEmail(request,user);
        checkUpdatePhoneNumber(request,user);
    }
    private void checkUpdateEmail(UpdateProfileRequest request,User user) {
        Optional<User> customer=repo.findCustomerByEmail(request.getEmail());
        if (customer.isPresent()){
            if (!customer.get().getId().equals(user.getId()))
                throw new CustomException(CustomException.Type.EMAIL_ALREADY_EXITS);
        }

    }
    private void checkUpdatePhoneNumber(UpdateProfileRequest request,User user) {
        Optional<User> customer=repo.findCustomerByPhoneNumber(request.getPhoneNumber());
        if (customer.isPresent()){
            if (!customer.get().getId().equals(user.getId()))
                throw new CustomException(CustomException.Type.PHONE_NUMBER_ALREADY_EXISTS);
        }
    }
    private void checkEmail(SignUpRequest request) {
        Optional<User> customer=repo.findCustomerByEmail(request.getEmail());
        if (customer.isPresent())
            throw new CustomException(CustomException.Type.EMAIL_ALREADY_EXITS);
    }
    private void checkUsername(SignUpRequest request) {
        Optional<User> customer=repo.findCustomerByUsername(request.getUsername());
        if (customer.isPresent())
            throw new CustomException(CustomException.Type.USERNAME_ALREADY_EXIST);
    }
    private void checkPhoneNumber(SignUpRequest request) {
        Optional<User> customer=repo.findCustomerByPhoneNumber(request.getPhoneNumber());
        if (customer.isPresent())
            throw new CustomException(CustomException.Type.PHONE_NUMBER_ALREADY_EXISTS);
    }
}
