package com.pedro.pecho.challenge.model;

import lombok.Data;

import java.util.Date;

/**
 * juniorpedro
 * 2019-03-12
 **/
@Data
public class CustomerRequest {

    private String name;
    private String lastName;
    private int age;
    private Date birthday;
}
