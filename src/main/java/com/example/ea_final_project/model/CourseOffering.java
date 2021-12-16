package com.example.ea_final_project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class CourseOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private int capacity;
    //private int availableSeats;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Course course;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Faculty faculty;
    @ManyToOne(cascade = CascadeType.MERGE)
    private AcademicBlock block;
    @OneToMany
    @JoinColumn(name="course_offering_id")
    private List<Registration> registrations = new ArrayList<>();
    @OneToMany
   // @JoinColumn(name="course_offering_id")
    private List<RegistrationRequest> registrationsRequests = new ArrayList<>();

    public CourseOffering(String code, int capacity, Course course, Faculty faculty, AcademicBlock block) {
        this.code = code;
        this.capacity = capacity;
        this.course = course;
        this.faculty = faculty;
        this.block = block;

        //FIXME function is returning number instead of character
        //createCourseCode();
        //TODO: CALCULATE AVAILABLE SEATS
    }

//    public void createCourseCode() {
//        this.code += faculty.getFirstname().charAt(0) + faculty.getLastname().charAt(0);
//    }

    public void calculateAvailableSeats() {

    }

    public void addRegistrationRequests(RegistrationRequest request) {
       registrationsRequests.add(request);

    }

}
