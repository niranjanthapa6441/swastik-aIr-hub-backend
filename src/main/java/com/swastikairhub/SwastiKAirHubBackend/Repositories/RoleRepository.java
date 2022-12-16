package com.swastikairhub.SwastiKAirHubBackend.Repositories;

import com.swastikairhub.SwastiKAirHubBackend.Role.ERole;
import com.swastikairhub.SwastiKAirHubBackend.Role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERole name);
}