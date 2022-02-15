package com.swastikairhub.SwastiKAirHubBackend.Customer.LoginAndRegistration.CustomerLoginAndRegistration.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u where u.email=?1")
    User findByEmail(String email);
    @Query("SELECT count(*) FROM User u where u.username=?1")
    public int findByUsername(String username);
    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
}

