package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepo extends CrudRepository<Sector,String> {
    @Query("SELECT se FROM Sector se where se.sectorName=?1")
    Sector findBySector(String sector);
}
