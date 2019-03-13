package com.pedro.pecho.challenge.service;

import com.pedro.pecho.challenge.model.CustomerKpiResponse;
import com.pedro.pecho.challenge.model.CustomerRequest;
import com.pedro.pecho.challenge.model.CustomerResponse;

import java.util.List;

/**
 * juniorpedro
 * 2019-03-12
 **/
public interface CustomerService {

    List<CustomerResponse> getAllCustomer();

    void saveCustomer(CustomerRequest customerRequest);

    CustomerKpiResponse getKpiCustomer();
}
