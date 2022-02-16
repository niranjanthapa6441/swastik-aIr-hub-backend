package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightTicketRepo extends JpaRepository<FlightTicket,String> {

}
