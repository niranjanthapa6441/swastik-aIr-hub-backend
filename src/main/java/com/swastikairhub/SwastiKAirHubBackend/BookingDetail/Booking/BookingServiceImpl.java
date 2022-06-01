package com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Booking;

import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Passenger.Passenger;
import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Passenger.PassengerRepo;
import com.swastikairhub.SwastiKAirHubBackend.BookingDetail.Passenger.PassengerRequest;
import com.swastikairhub.SwastiKAirHubBackend.PaymentDetail.Payment;
import com.swastikairhub.SwastiKAirHubBackend.PaymentDetail.PaymentRepo;
import com.swastikairhub.SwastiKAirHubBackend.PaymentDetail.PaymentServiceImpl;
import com.swastikairhub.SwastiKAirHubBackend.User.User;
import com.swastikairhub.SwastiKAirHubBackend.User.UserRepo;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepo repo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private FlightTicketRepo flightTicketRepo;
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private FlightRepo flightRepo;
    @Autowired
    private PassengerRepo passengerRepo;
    @Autowired
    private PaymentRepo paymentRepo;

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
        Booking booking = repo.save(toBooking(request));
        toPassengers(booking,request.getPassengerList());
        toPayment(booking,request);
        return toBookingDTO(booking);
    }

    @Override
    public BookingDTO delete(String id) {
        return null;
    }

    @Override
    public BookingDTO findById(String id) {
        Optional<Booking> booking=repo.findById(id);
        List<Passenger> passengers = new ArrayList<>();
        if (booking.isPresent()) {
            passengers=passengerRepo.findPassengerByBookingId(booking.get());
        }
        return toFindByBookingIdDTO(booking.get(),passengers);
    }

    @Override
    public Iterable<Booking> findByCustomerId(String id) {
        Optional<User> customer= userRepo.findById(id);
        /*if (customer.isEmpty())
            throw new NullPointerException("The Customer Doesn't exist");*/
        Iterable<Booking> bookings=repo.findBookingByCustomerId(customer);
        return bookings;
    }

    @Override
    public Iterable<PassengerTicketDTO> findTicketByBookingId(String id) {
        List<PassengerTicketDTO> passengerTickets= new ArrayList<>();
        Optional<Booking> booking=repo.findById(id);
        Iterable<Passenger> passengers= passengerRepo.findPassengerByBookingId(booking.get());
        for (Passenger passenger:passengers
             ) {
            PassengerTicketDTO passengerTicketDTO= new PassengerTicketDTO();
            passengerTicketDTO.setPassengerName(passenger.getFirstName()+passenger.getMiddleName()+passenger.getLastName());
            passengerTicketDTO.setDeparture(booking.get().getFlightTicket().getDetail().getSector().getFrom());
            passengerTicketDTO.setArrival(booking.get().getFlightTicket().getDetail().getSector().getTo());
            passengerTicketDTO.setFlightCode(booking.get().getFlightTicket().getDetail().getFlightCode());
            passengerTicketDTO.setTicketPrice(booking.get().getFlightTicket().getTicket().getPrice());
            passengerTicketDTO.setDepartureDate(booking.get().getFlightTicket().getDetail().getDepartureDate());
            passengerTicketDTO.setDepartureTime(booking.get().getFlightTicket().getDetail().getDepartureTime());
            passengerTicketDTO.setSectorCode(booking.get().getFlightTicket().getDetail().getSector().getSectorCode());
            passengerTicketDTO.setTicketNumber(booking.get().getId());
            passengerTickets.add(passengerTicketDTO);
        }
        return passengerTickets;
    }

    private Booking toBooking(BookingRequest request) {
        Ticket ticket = getTicket(request);
        FlightDetail flightDetail = getFlightDetail(request);
        FlightTicket flightTicket = getFlightTicket(ticket, flightDetail);
        Optional<User> findCustomer = getCustomer(request);
        Booking booking = getBooking(request, flightTicket, findCustomer);
        return booking;
    }

    private Booking getBooking(BookingRequest request, FlightTicket flightTicket, Optional<User> findCustomer) {
        System.out.println("ticket price"+request.getTotalTicketPrice());
        Booking booking = new Booking();
        booking.setBookingDate(LocalDate.now());
        booking.setBookingTime(LocalTime.now());
        booking.setCustomer(findCustomer.get());
        booking.setFlightTicket(flightTicket);
        booking.setStatus(request.getStatus());
        booking.setNumberOfTraveller(request.getNumberOfTraveller());
        booking.setTotalTicketPrice(request.getTotalTicketPrice());
        return booking;
    }

    private Ticket getTicket(BookingRequest request) {
        Ticket ticket = ticketRepo.findByTicketCode(request.getTicketCode());
        if (ticket == null)
            throw new NullPointerException("The Ticked Does not Exist");
        return ticket;
    }

    private FlightDetail getFlightDetail(BookingRequest request) {
        FlightDetail flightDetail = flightRepo.findByFlightCode(request.getFlightCode());
        if (flightDetail == null)
            throw new NullPointerException("The detail of the flight does not exist");
        return flightDetail;
    }

    private FlightTicket getFlightTicket(Ticket ticket, FlightDetail flightDetail) {
        FlightTicket flightTicket = flightTicketRepo.findFlightTicket(flightDetail, ticket);
        if (flightTicket == null)
            throw new NullPointerException("The ticket for the flight does not exist");
        return flightTicket;
    }

    private Optional<User> getCustomer(BookingRequest request) {
        Optional<User> findCustomer = userRepo.findById(request.getCustomerId());
        /*if (findCustomer.isEmpty())
            throw new NullPointerException("The Customer Does not Exist");*/
        return findCustomer;
    }

    private void toPassengers(Booking booking, List<PassengerRequest> passengerList) {
        for (PassengerRequest passengerRequest:passengerList
             ) {
            Passenger passenger = getPassenger(booking, passengerRequest);
            passengerRepo.save(passenger);
        }
    }

    private Passenger getPassenger(Booking booking, PassengerRequest passengerRequest) {
        Passenger passenger= new Passenger();
        passenger.setFirstName(passengerRequest.getFirstName());
        passenger.setMiddleName(passengerRequest.getMiddleName());
        passenger.setLastName(passengerRequest.getLastName());
        passenger.setPhoneNumber(passengerRequest.getPhoneNumber());
        passenger.setBooking(booking);
        return passenger;
    }

    private BookingDTO toBookingDTO(Booking booking) {
        List<Passenger> passengers=passengerRepo.findPassengerByBookingId(booking);
        return BookingDTO.builder().
                id(booking.getId()).
                bookingDate(String.valueOf(booking.getBookingDate())).
                bookingTime(String.valueOf(booking.getBookingTime())).
                customer(booking.getCustomer()).
                flightTicket(booking.getFlightTicket()).
                passengerList(passengers).
                totalPrice(booking.getTotalTicketPrice()).
                status(booking.getStatus()).build();
    }
    private BookingDTO toFindByBookingIdDTO(Booking booking, List<Passenger> passengers) {
        return BookingDTO.builder().
                id(booking.getId()).
                bookingDate(String.valueOf(booking.getBookingDate())).
                bookingTime(String.valueOf(booking.getBookingTime())).
                customer(booking.getCustomer()).
                flightTicket(booking.getFlightTicket()).
                passengerList(passengers).
                status(booking.getStatus()).build();
    }
    private void toPayment(Booking booking, BookingRequest request) {
        Payment payment= new Payment();
        payment.setPaymentDate(LocalDate.now());
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setPaymentTIme(LocalTime.now());
        payment.setStatus(request.getPaymentStatus());
        payment.setTotalAmount(request.getTotalTicketPrice());
        payment.setPaidVia(request.getPaidVia());
        payment.setBooking(booking);
        paymentRepo.save(payment);
    }
}
