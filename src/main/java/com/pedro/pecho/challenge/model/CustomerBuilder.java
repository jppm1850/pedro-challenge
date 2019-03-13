package com.pedro.pecho.challenge.model;

import com.pedro.pecho.challenge.constant.Constants;
import com.pedro.pecho.challenge.entity.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * juniorpedro
 * 2019-03-12
 **/
@Component
public class CustomerBuilder {

    @Value("${customer.average.life}")
    private int averageLife;

    public Customer buildCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setLastName(customerRequest.getLastName());
        customer.setAge(customerRequest.getAge());
        customer.setBirthday(customerRequest.getBirthday());

        return customer;
    }

    public CustomerResponse buildCustomerResponse(Customer customer){
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setName(customer.getName());
        customerResponse.setLastName(customer.getLastName());
        customerResponse.setAge(customer.getAge());
        customerResponse.setBirthday(customer.getBirthday());
        customerResponse.setDeathDate(calculateDeathDate(customer.getAge()));

        return customerResponse;

    }

    public CustomerKpiResponse buildCustomerKpiResponse(List<Customer> customers){


        CustomerKpiResponse customerKpiResponse = new CustomerKpiResponse();
        customerKpiResponse.setAverageAge(getAverageAge(customers));
        customerKpiResponse.setStandardDeviation(getStandardDeviation(customers));

        return customerKpiResponse;

    }

    private Double getAverageAge(List<Customer> customers){

        return customers.stream()
                .mapToInt(Customer::getAge)
                .average()
                .getAsDouble();
    }

    private Double getStandardDeviation(List<Customer> customers){
        Double averageAge = getAverageAge(customers);

        Double preCalculate = customers.stream().mapToInt(Customer::getAge)
                .mapToDouble(age-> age-averageAge)
                .map(result->Math.pow(result,2))
                .sum();

        return Math.sqrt(preCalculate/(customers.size()-1));
    }


    private String calculateDeathDate(int age){
        SimpleDateFormat format = new SimpleDateFormat(Constants.FORMAT_DATE);

        int restOfLifeYear = averageLife - age;
        Calendar deathDate = Calendar.getInstance();
        deathDate.add(Calendar.YEAR, restOfLifeYear);

        return format.format(deathDate.getTime());

    }
}
