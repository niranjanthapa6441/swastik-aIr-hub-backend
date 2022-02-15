package com.swastikairhub.SwastiKAirHubBackend.AirlineCompany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineCompanyRepo extends JpaRepository<AirlineCompany,String> {
}
