package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightService {
    FlightDTO save(FlightDetailRequest request);
    Iterable<FlightDetail> findAll();
    FlightDTO findByFlightCode(String flightCode);
    FlightDTO update(String id,FlightDetailRequest request);
    FlightDTO delete(String id);
    List<SearchFlightDTO> searchFlight(SearchFlightRequest request);
}
