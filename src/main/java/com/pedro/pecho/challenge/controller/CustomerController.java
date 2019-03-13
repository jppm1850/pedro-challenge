package com.pedro.pecho.challenge.controller;

import com.pedro.pecho.challenge.entity.Customer;
import com.pedro.pecho.challenge.model.CustomerKpiResponse;
import com.pedro.pecho.challenge.model.CustomerRequest;
import com.pedro.pecho.challenge.model.CustomerResponse;
import com.pedro.pecho.challenge.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * juniorpedro
 * 2019-03-12
 **/
@RestController("/challenge/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/status")
    public String checkStatus() {
        return "ok";
    }

    @RequestMapping(value = "/customers",method = RequestMethod.POST)
    public void saveCustomer(@RequestBody CustomerRequest customerRequest){
        customerService.saveCustomer(customerRequest);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<CustomerResponse> getAllCustomer(){
       return customerService.getAllCustomer();
    }

    @RequestMapping(value = "/customers/kpi", method = RequestMethod.GET)
    public CustomerKpiResponse getKpiCustomer(){
        return customerService.getKpiCustomer();
    }

}
