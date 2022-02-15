package com.swastikairhub.SwastiKAirHubBackend.AirlineCompany;

import org.springframework.stereotype.Service;

@Service
public interface AirlineCompanyService {
    AirlineDTO save(AirlineCompanyRequest request);
    Iterable<AirlineCompany> findAll();
    AirlineDTO findById(String id);
    AirlineDTO update(String id,AirlineCompanyRequest request);
    AirlineDTO delete(String id);
}
