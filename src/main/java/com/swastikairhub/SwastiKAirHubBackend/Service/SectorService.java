package com.swastikairhub.SwastiKAirHubBackend.Service;


import com.swastikairhub.SwastiKAirHubBackend.DTO.SectorDTO;
import com.swastikairhub.SwastiKAirHubBackend.Domain.Sector;
import com.swastikairhub.SwastiKAirHubBackend.Request.SectorRequest;
import org.springframework.stereotype.Service;

@Service
public interface SectorService {
    SectorDTO save(SectorRequest request);
    Iterable<Sector> findAll();
    SectorDTO findBySector(String sector);
    SectorDTO update(String id,SectorRequest request);
    SectorDTO delete(String id);
}
