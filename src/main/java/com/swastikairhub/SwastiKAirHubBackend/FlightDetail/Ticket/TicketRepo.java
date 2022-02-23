package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket;

import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,Integer> {
    @Query("SELECT tkt FROM Ticket tkt where tkt.ticketCode=?1")
    Ticket findByTicketCode(String ticketCode);
}
