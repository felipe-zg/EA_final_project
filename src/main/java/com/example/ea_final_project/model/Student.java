package com.example.ea_final_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person {

    private String studentId;
    @ManyToOne
    private RegistrationGroup registrationGroup;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address homeAddress;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address billingAddress;
//    private String name;
//    private String email;
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private Address homeAddress;
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private Address billingAddress;


}
