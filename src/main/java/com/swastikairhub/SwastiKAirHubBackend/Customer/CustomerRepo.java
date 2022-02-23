package com.swastikairhub.SwastiKAirHubBackend.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,String> {
    @Query("SELECT c FROM Customer c WHERE (c.username=?1 or c.email=?1) and c.password=?2")
    Customer findByUsernameAndPassword(String username, String password);

    @Query("SELECT c FROM Customer c WHERE c.username=?1")
    Optional<Customer> findCustomerByUsername(String username);
    @Query("SELECT c FROM Customer c WHERE c.email=?1")
    Optional<Customer> findCustomerByEmail(String email);
    @Query("SELECT c FROM Customer c WHERE c.phoneNumber=?1")
    Optional<Customer> findCustomerByPhoneNumber(String phoneNumber);
}
