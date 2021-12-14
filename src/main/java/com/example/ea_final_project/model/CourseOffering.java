package com.example.ea_final_project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class CourseOffering {
    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private int capacity;
    private int availableSeats;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Course course;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Faculty faculty;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private AcademicBlock block;

    public CourseOffering(String code, int capacity, Course course, Faculty faculty, AcademicBlock block) {
        this.code = code;
        this.capacity = capacity;
        this.course = course;
        this.faculty = faculty;
        this.block = block;
        //FIXME function is returning number instead of character
        createCourseCode();
        //TODO: CALCULATE AVAILABLE SEATS
    }

    public void createCourseCode() {
        this.code += faculty.getFirstname().charAt(0) + faculty.getLastname().charAt(0);
    }

    public void calculateAvailableSeats() {

    }
}
