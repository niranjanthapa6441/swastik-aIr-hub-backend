package com.swastikairhub.SwastiKAirHubBackend.Repositories;

import com.swastikairhub.SwastiKAirHubBackend.Domain.FlightDetail;
import com.swastikairhub.SwastiKAirHubBackend.Domain.FlightTicket;
import com.swastikairhub.SwastiKAirHubBackend.Domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightTicketRepo extends JpaRepository<FlightTicket,String> {
    @Query("SELECT flt FROM FlightTicket flt where flt.detail=?1 and flt.ticket=?2")
    FlightTicket findFlightTicket(FlightDetail detail, Ticket ticket);

    @Query("SELECT flt.ticket FROM FlightTicket flt where flt.detail=?1 ORDER BY flt.ticket.price")
    List<Ticket> findFlightTicketByFlight(FlightDetail detail);
}
