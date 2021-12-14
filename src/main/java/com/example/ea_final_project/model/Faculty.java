package com.example.ea_final_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Faculty  extends Person{
//    @Id
//    @GeneratedValue
//    private Integer id;
//    private String firstname;
//    private String lastname;
//    private String email;
    private String title;

}
