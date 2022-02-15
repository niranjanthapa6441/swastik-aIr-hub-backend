package com.swastikairhub.SwastiKAirHubBackend.Customer.LoginAndRegistration.CustomerLoginAndRegistration.User;

import com.swastikairhub.SwastiKAirHubBackend.Customer.LoginAndRegistration.CustomerLoginAndRegistration.Exceptions.EtAuthException;
import com.swastikairhub.SwastiKAirHubBackend.Customer.LoginAndRegistration.CustomerLoginAndRegistration.User.Registration.RegistrationToken.ConfirmationToken;
import com.swastikairhub.SwastiKAirHubBackend.Customer.LoginAndRegistration.CustomerLoginAndRegistration.User.Registration.RegistrationToken.ConfirmationTokenService;
import com.swastikairhub.SwastiKAirHubBackend.Customer.LoginAndRegistration.CustomerLoginAndRegistration.User.Role.RoleRepository;
import com.swastikairhub.SwastiKAirHubBackend.Customer.LoginAndRegistration.CustomerLoginAndRegistration.User.Role.UserRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final static String EMAIL_NOT_FOUND = "user with email %s not found";
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ConfirmationTokenService confirmationTokenService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Email does not exist");
        }
        return new CustomUserDetails(user);
    }

    @Override
    public User validateUser(User user) throws EtAuthException {
        return null;
    }

    @Override
    public String registerUser(User newUser) {
        User userExists= userRepository
                .findByEmail(newUser.getEmail());
        if(userExists != null){
            throw new EtAuthException("The email already exists");
        }
        int countUsername=userRepository.findByUsername(newUser.getUsername());
        if(countUsername > 0){
            throw new EtAuthException("The username already exists");
        }
        String encodedPassword = bCryptPasswordEncoder
                .encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);
        UserRole roleUser = roleRepository.findByName("Customer");
        newUser.addRole(roleUser);
        userRepository.save(newUser);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                newUser
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }
    @Override
    public Iterable<User> findAllUser() throws EtAuthException {
        return userRepository.findAll();
    }

    @Override
    public int enableAppUser(String email) {
        return userRepository.enableAppUser(email);
    }

}
