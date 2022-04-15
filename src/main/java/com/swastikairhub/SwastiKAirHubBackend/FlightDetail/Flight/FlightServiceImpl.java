package com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Flight;


import com.swastikairhub.SwastiKAirHubBackend.AirlineCompany.AirlineCompany;
import com.swastikairhub.SwastiKAirHubBackend.AirlineCompany.AirlineCompanyRepo;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.FlightTicket.FlightTicketRepo;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector.Sector;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Sector.SectorRepo;
import com.swastikairhub.SwastiKAirHubBackend.FlightDetail.Ticket.Ticket;
import com.swastikairhub.SwastiKAirHubBackend.Util.CustomException;
import com.swastikairhub.SwastiKAirHubBackend.Util.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepo flightRepo;

    @Autowired
    private SectorRepo sectorRepo;

    @Autowired
    private AirlineCompanyRepo companyRepo;
    @Autowired
    private FlightTicketRepo flightTicketRepo;

    @Override
    public FlightDTO save(FlightDetailRequest request) {
        checkValidation(request);
        FlightDetail flightDetail = flightRepo.save(toFlightDetail(request));
        return toFlightDTO(flightDetail);
    }

    @Override
    public Iterable<FlightDetail> findAll() {
        return flightRepo.findAll();
    }

    @Override
    public FlightDTO findByFlightCode(String flightCode) {
        FlightDetail detail = flightRepo.findByFlightCode(flightCode);
        if (detail != null)
            return toFlightDTO(detail);
        else
            throw new NullPointerException("The Flight does not exist");
    }

    @Override
    public FlightDTO update(String id, FlightDetailRequest request) {
        checkValidation(request);
        Optional<FlightDetail> flightDetail = flightRepo.findById(id);
        if (flightDetail.isPresent()) {
            FlightDetail updateFlightDetail = toFlightDetail(request);
            updateFlightDetail.setId(id);
            FlightDetail updatedFlightDetail = flightRepo.save(updateFlightDetail);
            return toFlightDTO(updatedFlightDetail);
        } else
            throw new NullPointerException("The flight does not exist");
    }

    @Override
    public FlightDTO delete(String id) {
        Optional<FlightDetail> flightDetail = flightRepo.findById(id);
        if (flightDetail.isPresent()) {
            FlightDetail deleteDetail = flightDetail.get();
            deleteDetail.setStatus("Terminated");
            FlightDetail deletedDetail = flightRepo.save(deleteDetail);
            return toFlightDTO(deletedDetail);
        } else
            throw new NullPointerException("The flight does not exist");
    }

    @Override
    public List<SearchFlightDTO> searchFlight(SearchFlightRequest request) {
        DateTimeFormatter dateFormatter = new DateTimeFormatter();
        LocalDate date = dateFormatter.formatDate(request.getDepartureDate());
        Sector sector = toSector(request.getSectorCode());
        List<FlightDetail> searchFlights = toSearchFlight(sector, date, request.getNumberOfTraveller());
        List<SearchFlightDTO> searchFlightDTOS = getSearchFlightDTOS(searchFlights);
        if (searchFlightDTOS.isEmpty()){
            throw new NullPointerException("Flights for sector "+request.getSectorCode()+"and"+"\n"+" departure date "+request.getDepartureDate()+"does not exist");
        }
        return searchFlightDTOS;
    }

    private List<SearchFlightDTO> getSearchFlightDTOS(List<FlightDetail> searchFlights) {
        List<SearchFlightDTO> searchFlightDTOS = new ArrayList<>();
        for (FlightDetail detail : searchFlights
        ) {
            List<Ticket> flightTickets = flightTicketRepo.findFlightTicketByFlight(detail);
            for (Ticket ticket:flightTickets
                 ) {
                SearchFlightDTO searchFlightDTO=toSearchFlightDTO(detail,ticket);
                searchFlightDTOS.add(searchFlightDTO);
            }
            /*SearchFlightDTO searchFlightDTO = getSearchFlightDTO(detail, flightTickets);*/
        }

        List<SearchFlightDTO> listOfFlights = getFlightDTOS(sortByTicketPriceAsc(searchFlightDTOS));
        return listOfFlights;
    }

    private SearchFlightDTO toSearchFlightDTO(FlightDetail detail, Ticket ticket) {
        SearchFlightDTO searchFlightDTO = new SearchFlightDTO();
        searchFlightDTO.setCompanyName(detail.getCompany().getName());
        searchFlightDTO.setFlightCode(detail.getFlightCode());
        searchFlightDTO.setSector(detail.getSector());
        searchFlightDTO.setDepartureDate(String.valueOf(detail.getDepartureDate()));
        searchFlightDTO.setDepartureTime(String.valueOf(detail.getDepartureTime()));
        searchFlightDTO.setStatus(detail.getStatus());
        searchFlightDTO.setTicket(ticket);
        return searchFlightDTO;
    }

    private List<SearchFlightDTO> getFlightDTOS(List<SearchFlightDTO> searchFlightDTOS) {
        List<SearchFlightDTO> listOfFlights = new ArrayList<>();
        for (SearchFlightDTO dto : searchFlightDTOS
        ) {
            if (dto.getTicket()!=null) {
                listOfFlights.add(dto);
            }
        }
        return listOfFlights;
    }

/*    private SearchFlightDTO getSearchFlightDTO(FlightDetail detail, List<Ticket> flightTickets) {
        SearchFlightDTO searchFlightDTO = new SearchFlightDTO();
        searchFlightDTO.setCompanyName(detail.getCompany().getName());
        searchFlightDTO.setFlightCode(detail.getFlightCode());
        searchFlightDTO.setSector(detail.getSector());
        searchFlightDTO.setDepartureDate(String.valueOf(detail.getDepartureDate()));
        searchFlightDTO.setDepartureTime(String.valueOf(detail.getDepartureTime()));
        searchFlightDTO.setStatus(detail.getStatus());
        //searchFlightDTO.setTickets(flightTickets);
        return searchFlightDTO;
    }*/

    private FlightDetail toFlightDetail(FlightDetailRequest request) {
        DateTimeFormatter dateFormatter = new DateTimeFormatter();
        LocalDate date = dateFormatter.formatDate(request.getDepartureDate());
        /*LocalDateTime departureTime=dateFormatter.formatLocalDateTime(request.getDepartureTime());
        System.out.println(LocalDate.now());
        System.out.println(date);
        LocalTime parseTime=LocalTime.parse("01:15");
        System.out.println(parseTime);
        if (LocalDate.now().isEqual(date)){System.out.println(LocalTime.now().plusHours(2));
            LocalTime time=LocalTime.now().plusHours(2);
            Long totalHours = ChronoUnit.HOURS.between(LocalTime.now().plusHours(1),parseTime);
            System.out.println(totalHours);
        }*/
        FlightDetail flightDetail = new FlightDetail();
        flightDetail.setFlightCode(request.getFlightCode());
        flightDetail.setStatus(request.getStatus());
        flightDetail.setCompany(toCompany(request.getCompanyName()));
        flightDetail.setDepartureDate(date);
        flightDetail.setSector(toSector(request.getSectorCode()));
        flightDetail.setDepartureTime(request.getDepartureTime());
        flightDetail.setNumberOfAvailableSeats(request.getAvailableSeats());
        return flightDetail;
    }

    private FlightDTO toFlightDTO(FlightDetail flightDetail) {
        return FlightDTO.builder().id(flightDetail.getId()).
                flightCode(flightDetail.getFlightCode())
                .departureTime(String.valueOf(flightDetail.getDepartureTime())).
                company(flightDetail.getCompany()).
                sector(flightDetail.getSector()).
                status(flightDetail.getStatus()).
                departureDate(String.valueOf(flightDetail.getDepartureDate())).build();
    }

    private Sector toSector(String sector) {
        Sector findSector = sectorRepo.findBySector(sector);
        if (findSector != null) {
            return findSector;
        } else
            throw new NullPointerException("Sector Doesn't exist");
    }

    private List<FlightDetail> toSearchFlight(Sector sector, LocalDate date, int numberOfTraveller) {
        if (numberOfTraveller == 0)
            throw new CustomException(CustomException.Type.INVALID_NUMBER_OF_TRAVELLERS);
        List<FlightDetail> flightDetails = flightRepo.findFlightBySectorAndDate(sector, date, numberOfTraveller);
        if (flightDetails.isEmpty())
            throw new NullPointerException("No Available Flights for"+ "\n"+"Departure date: " + date + "\n"+"and " + "Sector: " + sector.getSectorCode());
        return flightDetails;
    }

    private AirlineCompany toCompany(String companyName) {
        AirlineCompany company = companyRepo.findByCompanyName(companyName);
        if (company != null) {
            return company;
        } else
            throw new NullPointerException("The company does not exist");
    }

    private void checkValidation(FlightDetailRequest request) {
        checkFlightCode(request.getFlightCode());
        checkFlightForTheDate(request);
    }

    private void checkFlightForTheDate(FlightDetailRequest request) {
        Sector sector = toSector(request.getSectorCode());
        AirlineCompany company = toCompany(request.getCompanyName());
        DateTimeFormatter dateFormatter = new DateTimeFormatter();
        LocalDate date = dateFormatter.formatDate(request.getDepartureDate());
        int count = flightRepo.findFlightBySectorDateAndTime(sector, company, date, request.getDepartureTime());
        if (count > 0)
            throw new CustomException(CustomException.Type.FLIGHT_ALREADY_EXIST);
    }

    private void checkFlightCode(String flightCode) {
        int count = flightRepo.countFlightCode(flightCode);
        if (count > 0)
            throw new CustomException(CustomException.Type.FLIGHT_CODE_ALREADY_EXIST);
    }
    private List<SearchFlightDTO> sortByTicketPriceAsc(List<SearchFlightDTO> searchFlightDTOS) {
        int n=searchFlightDTOS.size();
        SearchFlightDTO[] array = new SearchFlightDTO[searchFlightDTOS.size()];
        searchFlightDTOS.toArray(array);
        SearchFlightDTO temp= new SearchFlightDTO();
        if (searchFlightDTOS != null) {
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {
                    if (array[j - 1].getTicket().getPrice() > array[j].getTicket().getPrice()) {
                        temp = array[j - 1];
                        array[j - 1]=array[j];
                        array[j]=temp;
                    }
                }
            }
        }
        List<SearchFlightDTO> sortedSearchFlights= Arrays.asList(array);
        return sortedSearchFlights;
    }
    private List<SearchFlightDTO> sortByTicketPriceDesc(List<SearchFlightDTO> searchFlightDTOS) {
        int n = searchFlightDTOS.size();
        SearchFlightDTO[] array = new SearchFlightDTO[searchFlightDTOS.size()];
        searchFlightDTOS.toArray(array);
        SearchFlightDTO temp = new SearchFlightDTO();
        if (searchFlightDTOS != null) {
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {
                    if (array[j - 1].getTicket().getPrice() < array[j].getTicket().getPrice()) {
                        temp = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
        List<SearchFlightDTO> sortedSearchFlights = Arrays.asList(array);
        return sortedSearchFlights;
    }

}
