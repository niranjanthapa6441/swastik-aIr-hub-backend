package com.swastikairhub.SwastiKAirHubBackend.AirlineCompany;

import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineCompanyRepo extends JpaRepository<AirlineCompany,String> {
    @Query("SELECT ac FROM AirlineCompany ac where ac.name=?1")
    AirlineCompany findByCompanyName(String name);
    @Query("SELECT count(*) FROM AirlineCompany e where e.phoneNumber=?1")
    int countPhoneNumber(String phoneNumber);
    @Query("SELECT count(*) FROM AirlineCompany e where e.name=?1")
    int countName(String name);
    @Query("SELECT count(*) FROM AirlineCompany e where e.email=?1")
    int countEmail(String email);
}
