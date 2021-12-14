package com.example.ea_final_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private Integer id;
    private String street;
    private String city;
    private String postalCode;
    private String state;
    private String country;
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private Country country;
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private State state;

}
