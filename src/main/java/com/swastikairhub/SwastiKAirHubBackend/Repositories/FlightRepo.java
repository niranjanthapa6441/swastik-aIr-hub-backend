package com.swastikairhub.SwastiKAirHubBackend.Repositories;

import com.swastikairhub.SwastiKAirHubBackend.Domain.AirlineCompany;
import com.swastikairhub.SwastiKAirHubBackend.Domain.FlightDetail;
import com.swastikairhub.SwastiKAirHubBackend.Domain.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<FlightDetail,String> {
    @Query("SELECT fd FROM FlightDetail fd where fd.flightCode=?1")
    FlightDetail findByFlightCode(String flightCode);
    @Query("SELECT ea FROM FlightDetail ea where ea.sector=?1 and ea.departureDate=?2 and ea.numberOfAvailableSeats >= ?3")
    List<FlightDetail> findFlightBySectorAndDate(Sector sector,LocalDate date,int numberOfTraveller);

    @Query("SELECT count(*) FROM FlightDetail ea where ea.sector=?1 and ea.company=?2 and ea.departureDate=?3 and ea.departureTime=?4" )
    int findFlightBySectorDateAndTime(Sector sector, AirlineCompany company, LocalDate date, String time);

    @Query("SELECT count(*) FROM FlightDetail fd where fd.flightCode=?1")
    int countFlightCode(String flightCode);
}
