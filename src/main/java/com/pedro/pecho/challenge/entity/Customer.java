package com.pedro.pecho.challenge.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * juniorpedro
 * 2019-03-12
 **/
@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private int age;

    @Column
    private Date birthday;
}
