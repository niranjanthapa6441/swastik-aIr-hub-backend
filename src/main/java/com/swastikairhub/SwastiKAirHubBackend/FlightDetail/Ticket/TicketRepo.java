package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends CrudRepository<Ticket,Integer> {
}
