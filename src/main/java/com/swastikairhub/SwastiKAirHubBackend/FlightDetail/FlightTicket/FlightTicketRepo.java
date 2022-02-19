package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket;

import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight.FlightDetail;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector.Sector;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket.Ticket;
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
