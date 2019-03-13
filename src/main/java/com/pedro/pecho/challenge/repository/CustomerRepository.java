package com.pedro.pecho.challenge.repository;

import com.pedro.pecho.challenge.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * juniorpedro
 * 2019-03-12
 **/
public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
