package com.example.ea_final_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class RegistrationRequest {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer priority;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private  Student student;
}
