package com.swastikairhub.SwastiKAirHubBackend.Service;

import com.swastikairhub.SwastiKAirHubBackend.DTO.FlightDTO;
import com.swastikairhub.SwastiKAirHubBackend.DTO.SearchFlightDTO;
import com.swastikairhub.SwastiKAirHubBackend.Domain.FlightDetail;
import com.swastikairhub.SwastiKAirHubBackend.Request.FlightDetailRequest;
import com.swastikairhub.SwastiKAirHubBackend.Request.SearchFlightRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface FlightService {
    FlightDTO save(FlightDetailRequest request);
    Iterable<FlightDetail> findAll();
    FlightDTO findByFlightCode(String flightCode);
    FlightDTO update(String id,FlightDetailRequest request);
    FlightDTO delete(String id);

    Page<SearchFlightDTO> searchFlight(SearchFlightRequest request, int pageNumber, int pageSize);
}
