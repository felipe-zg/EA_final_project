package com.example.ea_final_project.model;

import com.example.ea_final_project.model.utils.Status;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer priority;
    private Status status;
    @ManyToOne
    private  Student student;
    @ManyToOne(cascade = CascadeType.MERGE)
    private CourseOffering courseOffering;
}
