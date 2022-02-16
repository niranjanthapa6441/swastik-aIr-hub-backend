package com.swastikairhub.SwastiKAirHubBackend.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo repo;

    @Override
    public CustomerDTO save(CustomerRequest request) {
        Customer customer = toCustomer(request);
        Customer saveCustomer = repo.save(customer);
        return toCustomerDTO(saveCustomer);
    }

    @Override
    public Iterable<Customer> findAll() {
        return repo.findAll();
    }

    @Override
    public CustomerDTO update(String id, CustomerRequest request) {
        Optional<Customer> findCustomer = repo.findById(id);
        if (findCustomer.isPresent()) {
            Customer updateCustomer = toCustomer(request);
            updateCustomer.setId(id);
            Customer updatedCustomer = repo.save(updateCustomer);
            return toCustomerDTO(updatedCustomer);
        } else
            throw new NullPointerException("The customer does not exist");
    }

    @Override
    public CustomerDTO delete(String id) {
        Optional<Customer> findCustomer = repo.findById(id);
        if (findCustomer.isPresent()) {
            Customer deleteCustomer = findCustomer.get();
            deleteCustomer.setStatus("terminated");
            Customer deletedCustomer = repo.save(deleteCustomer);
            return toCustomerDTO(deletedCustomer);
        } else
            throw new NullPointerException("The Customer Doesn't Exist");
    }

    @Override
    public CustomerDTO findById(String id) {
        Optional<Customer> findCustomer = repo.findById(id);
        if (findCustomer.isPresent()) {
            Customer customer = findCustomer.get();
            return toCustomerDTO(customer);
        } else
            throw new NullPointerException("The Customer Doesn't Exist");
    }

    private CustomerDTO toCustomerDTO(Customer customer) {
        return CustomerDTO.builder().
                id(customer.getId()).
                email(customer.getEmail()).
                firstName(customer.getFirstName()).
                lastName(customer.getLastName()).
                middleName(customer.getMiddleName()).
                phoneNumber(customer.getPhoneNumber()).
                build();
    }

    private Customer toCustomer(CustomerRequest request) {
        Customer customer=new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setEmail(request.getEmail());
        customer.setLastName(request.getLastName());
        customer.setMiddleName(request.getMiddleName());
        customer.setPhoneNumber(request.getPhoneNumber());
        return customer;
    }
}
