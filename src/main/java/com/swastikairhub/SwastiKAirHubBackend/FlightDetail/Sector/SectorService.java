package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector;


import org.springframework.stereotype.Service;

@Service
public interface SectorService {
    SectorDTO save(SectorRequest request);
    Iterable<Sector> findAll();
    SectorDTO findBySector(String sector);
    SectorDTO update(String id,SectorRequest request);
    SectorDTO delete(String id);
}
