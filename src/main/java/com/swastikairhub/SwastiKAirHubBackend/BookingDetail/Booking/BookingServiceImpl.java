package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.swastikairhub.SwastiKAirHubBackend.Customer.Customer;
import com.swastikairhub.SwastiKAirHubBackend.Customer.CustomerRepo;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight.FlightDetail;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight.FlightRepo;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket.FlightTicket;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket.FlightTicketRepo;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket.Ticket;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepo repo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private FlightTicketRepo flightTicketRepo;
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private FlightRepo flightRepo;
    @Override
    public Iterable<Booking> findAll() {
        return repo.findAll();
    }

    @Override
    public BookingDTO update(String id, BookingRequest request) {
        return null;
    }

    @Override
    public BookingDTO save(BookingRequest request) {
        Booking booking=repo.save(toBooking(request));
        return toBookingDTO(booking);
    }

    @Override
    public BookingDTO delete(String id) {
        return null;
    }

    @Override
    public BookingDTO findById(String id) {
        return null;
    }

    @Override
    public Iterable<Booking> findByCustomerId(String id) {
        return null;
    }
    private Booking toBooking(BookingRequest request) {
        Ticket ticket=ticketRepo.findByTicketCode(request.getTicketCode());
        if (ticket == null)
            throw new NullPointerException("The Ticked Does not Exist");
        FlightDetail flightDetail=flightRepo.findByFlightCode(request.getFlightCode());
        if (flightDetail == null)
            throw  new NullPointerException("The detail of the flight does not exist");
        FlightTicket flightTicket=flightTicketRepo.findFlightTicket(flightDetail,ticket);
        if (flightTicket == null)
            throw  new NullPointerException("The ticket for the flight does not exist");
        Optional<Customer> findCustomer=customerRepo.findById(request.getCustomerId());
        if (findCustomer.isEmpty())
            throw  new NullPointerException("The Customer Does not Exist");

        Booking booking=new Booking();
        booking.setBookingDate(LocalDate.now());
        booking.setBookingTime(LocalTime.now());
        booking.setCustomer(findCustomer.get());
        booking.setFlightTicket(flightTicket);
        booking.setStatus("BOOKED");
        return booking;
    }
    private BookingDTO toBookingDTO(Booking booking) {
        return BookingDTO.builder().
                id(booking.getId()).
                bookingDate(String.valueOf(booking.getBookingDate())).
                bookingTime(String.valueOf(booking.getBookingTime())).
                customer(booking.getCustomer()).
                flightTicket(booking.getFlightTicket()).
                status(booking.getStatus()).build();}
}
