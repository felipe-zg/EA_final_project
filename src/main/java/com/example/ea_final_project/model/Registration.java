package com.example.ea_final_project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CourseOffering courseOffering;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Student student;

    public Registration(CourseOffering courseOffering, Student student) {
        this.courseOffering = courseOffering;
        this.student = student;
    }
}
