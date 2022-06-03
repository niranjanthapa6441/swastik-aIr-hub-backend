package com.swastikairhub.SwastiKAirHubBackend.Repositories;

import com.swastikairhub.SwastiKAirHubBackend.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,String> {

    Optional<User> findCustomerByUsername(String username);
    Optional<User> findCustomerByEmail(String email);
    Optional<User> findCustomerByPhoneNumber(String phoneNumber);
    Optional<User> findByUsername(String username);
    @Query("UPDATE User a SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
}
