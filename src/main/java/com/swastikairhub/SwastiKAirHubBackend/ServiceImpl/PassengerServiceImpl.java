package com.swastikairhub.SwastiKAirHubBackend.ServiceImpl;

import com.swastikairhub.SwastiKAirHubBackend.Domain.Booking;
import com.swastikairhub.SwastiKAirHubBackend.Domain.Passenger;
import com.swastikairhub.SwastiKAirHubBackend.DTO.PassengerDTO;
import com.swastikairhub.SwastiKAirHubBackend.Repositories.PassengerRepo;
import com.swastikairhub.SwastiKAirHubBackend.Service.PassengerService;
import com.swastikairhub.SwastiKAirHubBackend.Request.PassengerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private PassengerRepo repo;

    @Override
    public Iterable<Passenger> findAll() {
        return repo.findAll();
    }

    @Override
    public PassengerDTO save(PassengerRequest request) {
        Passenger passenger = repo.save(ToPassenger(request));
        return toPassengerDTO(passenger);
    }

    @Override
    public PassengerDTO findPassengerByBookingID(String id) {
        return null;
    }

    @Override
    public String delete(Booking booking) {
        Iterable<Passenger> passenger=repo.findPassengerByBookingId(booking);
        if (passenger != null){
            repo.deleteAll(passenger);
            return "deleted";
        }
        else
            throw  new NullPointerException("The booking id doesn't exist");
    }

    private PassengerDTO toPassengerDTO(Passenger passenger) {
        return PassengerDTO.builder().
                firstName(passenger.getFirstName()).
                id(passenger.getId()).
                lastName(passenger.getLastName()).
                middleName(passenger.getMiddleName()).
                phoneNumber(passenger.getPhoneNumber()).
                build();
    }

    private Passenger ToPassenger(PassengerRequest request) {
        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getFirstName());
        passenger.setLastName(passenger.getLastName());
        passenger.setMiddleName(passenger.getMiddleName());
        passenger.setPhoneNumber(passenger.getPhoneNumber());
        return passenger;
    }
}
