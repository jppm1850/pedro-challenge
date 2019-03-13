package com.pedro.pecho.challenge.service.impl;

import com.pedro.pecho.challenge.entity.Customer;
import com.pedro.pecho.challenge.model.CustomerBuilder;
import com.pedro.pecho.challenge.model.CustomerKpiResponse;
import com.pedro.pecho.challenge.model.CustomerRequest;
import com.pedro.pecho.challenge.model.CustomerResponse;
import com.pedro.pecho.challenge.repository.CustomerRepository;
import com.pedro.pecho.challenge.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * juniorpedro
 * 2019-03-12
 **/
@Repository
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerBuilder customerBuilder;

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerResponse> getAllCustomer(){
        return customerRepository.findAll().stream()
                .map(customerBuilder::buildCustomerResponse)
                .collect(Collectors.toList());
    }


    public void saveCustomer(CustomerRequest customerRequest) {
        Customer customer = customerBuilder.buildCustomer(customerRequest);
        customerRepository.save(customer);
    }

    @Override
    public CustomerKpiResponse getKpiCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return customerBuilder.buildCustomerKpiResponse(customers);
    }


}
