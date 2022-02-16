package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight;

import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<FlightDetail,String> {
    @Query("SELECT fd FROM FlightDetail fd where fd.flightCode=?1")
    FlightDetail findByFlightCode(String flightCode);
}
