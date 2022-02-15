package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightService {
    FlightDTO save(FlightRequest request);
    Iterable<Flight> findAll();
    FlightDTO findBySector(String sector);
    FlightDTO update(String id,FlightRequest request);
    FlightDTO delete(String id);
    List<FlightDTO> searchFlight(SearchFlightRequest request);
}
