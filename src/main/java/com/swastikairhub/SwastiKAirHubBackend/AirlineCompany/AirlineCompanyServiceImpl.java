package com.swastikairhub.SwastiKAirHubBackend.AirlineCompany;

import com.swastikairhub.SwastiKAirHubBackend.Util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirlineCompanyServiceImpl implements AirlineCompanyService{
    @Autowired
    private AirlineCompanyRepo repository;

    AirlineCompany airlineCompany;

    @Override
    public AirlineDTO save(AirlineCompanyRequest request) {
        checkValidation(request);
        airlineCompany = repository.save(toAirlineCompany(request));
        return toAirlineCompanyDTO(airlineCompany);
    }

    private void checkValidation(AirlineCompanyRequest request) {
        checkEmailValidation(request.getEmail());
        checkCompanyNameValidation(request.getName());
        checkPhoneNumber(request.getPhoneNumber());
    }

    @Override
    public Iterable<AirlineCompany> findAll() {
        return repository.findAll();
    }

    @Override
    public AirlineDTO findById(String id) {
        Optional<AirlineCompany> company = repository.findById(id);
        if (company.isPresent()) {
            AirlineCompany companyPresent = company.get();
            return toAirlineCompanyDTO(companyPresent);
        } else {
            throw new NullPointerException("Company Does not Exist");
        }
    }

    @Override
    public AirlineDTO update(String id, AirlineCompanyRequest request) {
        Optional<AirlineCompany> company = repository.findById(id);
        checkValidation(request);
        if (company.isPresent()) {
            AirlineCompany updateCompany = toAirlineCompany(request);
            updateCompany.setId(id);
            AirlineCompany updatedCompany = repository.save(updateCompany);
            return toAirlineCompanyDTO(updatedCompany);
        } else {
            throw new NullPointerException("Company Does not Exist");
        }
    }

    @Override
    public AirlineDTO delete(String id) {
        Optional<AirlineCompany> company = repository.findById(id);
        if (company.isPresent()) {
            AirlineCompany deleteCompany = company.get();
            deleteCompany.setContractStatus("terminated");
            AirlineCompany deletedCrew = repository.save(deleteCompany);
            return toAirlineCompanyDTO(deletedCrew);
        } else {
            throw new NullPointerException("Company Doesn't exist");
        }
    }

    private AirlineCompany toAirlineCompany(AirlineCompanyRequest request) {
        airlineCompany = new AirlineCompany();
        airlineCompany.setEmail(request.getEmail());
        airlineCompany.setName(request.getName());
        airlineCompany.setAddress(request.getAddress());
        airlineCompany.setContractDate(request.getContractDate());
        airlineCompany.setContractStatus(request.getContractStatus());
        airlineCompany.setPhoneNumber(request.getPhoneNumber());
        return airlineCompany;
    }

    private AirlineDTO toAirlineCompanyDTO(AirlineCompany company) {
        return AirlineDTO.builder().
                id(company.getId()).
                email(company.getEmail()).
                name(company.getName()).
                phoneNumber(company.getPhoneNumber()).
                address(company.getAddress()).
                contractDate(company.getContractDate()).
                contractStatus(company.getContractStatus()).
                build();
    }
    private void checkPhoneNumber(String phoneNumber) {
        int count= repository.countPhoneNumber(phoneNumber);
        if(count>0){
            throw new CustomException(CustomException.Type.PHONE_NUMBER_ALREADY_EXISTS);
        }
    }

    private void checkCompanyNameValidation(String name) {
        int count= repository.countName(name);
        if(count>0){
            throw new CustomException(CustomException.Type.COMPANY_ALREADY_ADDED);
        }
    }

    private void checkEmailValidation(String email) {
        int count= repository.countEmail(email);
        if(count>0){
            throw new CustomException(CustomException.Type.EMAIL_ALREADY_EXITS);
        }
    }
}
