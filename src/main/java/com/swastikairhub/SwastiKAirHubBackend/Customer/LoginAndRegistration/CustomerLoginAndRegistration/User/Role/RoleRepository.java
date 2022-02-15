package com.swastikairhub.SwastiKAirHubBackend.Customer.LoginAndRegistration.CustomerLoginAndRegistration.User.Role;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<UserRole,Integer> {
    @Query("Select r FROM UserRole  r where r.name = ?1")
    public UserRole findByName(String role);
}
