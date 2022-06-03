package com.swastikairhub.SwastiKAirHubBackend.Service;

import com.swastikairhub.SwastiKAirHubBackend.Domain.AirlineCompany;
import com.swastikairhub.SwastiKAirHubBackend.DTO.AirlineDTO;
import com.swastikairhub.SwastiKAirHubBackend.Request.AirlineCompanyRequest;
import org.springframework.stereotype.Service;

@Service
public interface AirlineCompanyService {
    AirlineDTO save(AirlineCompanyRequest request);
    Iterable<AirlineCompany> findAll();
    AirlineDTO findById(String id);
    AirlineDTO update(String id,AirlineCompanyRequest request);
    AirlineDTO delete(String id);
}
