package com.swastikairhub.SwastiKAirHubBackend.AirlineCompany;

import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineCompanyRepo extends JpaRepository<AirlineCompany,String> {
    @Query("SELECT ac FROM AirlineCompany ac where ac.name=?1")
    AirlineCompany findByCompanyName(String name);
}
