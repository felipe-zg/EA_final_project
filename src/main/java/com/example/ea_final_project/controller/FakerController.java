package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.*;
import com.example.ea_final_project.service.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/faker")
public class FakerController {
    @Autowired
    CourseService courseService;
    @Autowired
    StudentService studentService;
    @Autowired
    RegistrationGroupService registrationGroupService;
    @Autowired
    FacultyService facultyService;
    @Autowired
    AcademicBlockService blockService;
    @Autowired
    AddressService addressService;
    @Autowired
    CourseOfferingService courseOfferingService;
    @Autowired
    RegistrationService registrationService;
    @Autowired
    RegistrationEventService registrationEventService;
    @Autowired
    RegistrationRequestService registrationRequestService;

    @GetMapping
    public void addData() {
        fakerCourse();
        fakerStudent();
        fakerAddress();
        fakerFaculty();
    }

    public void fakerCourse() {
        String[] names = {
                "Fundamnetal of Progarmming Practice",
                "Modern Programming Practice",
                "Enterprise Archtecture",
                "Software Archttecture",
                "Algorithms",
                "Modern Web Application",
        };
        String[] codes = {
                "CS390",
                "CS400",
                "CS544",
                "CS577",
                "CS425",
                "CS572",
        };
        for (int i = 0; i < 6; i++) {
            Course course = new Course();
            course.setName(names[i]);
            course.setCode(codes[i]);
            course.setDescription(" description goes here");
            courseService.create(course);
        }
    }

    public void fakerStudent() {
        List<Address>addresses=addressService.findAll();
        Faker faker = new Faker();
        for (int i = 50; i < 150; i++) {
            Student student = new Student();
            student.setFirstname(faker.name().firstName());
            student.setLastname(faker.name().lastName());
            student.setPassword(faker.name().firstName());
            student.setStudentId("41-45" + i);
            AcademicBlock academicBlock = new AcademicBlock();
            academicBlock.setId(4 % i);
            //RegistrationGroup group = new RegistrationGroup();
            //group.setId(3);
            //student.setGroup(group);
           // student.getBillingAddress();
            //student.setHomeAddress(addresses);
            student.setEmail(faker.bothify("????##@gmail.com"));
            studentService.create(student);
        }
    }

    public void fakerAddress() {
        Faker faker = new Faker();
        for (int i = 1; i < 100; i++) {
            Address address = new Address();
            address.setStreet(faker.address().streetAddress());
            address.setPostalCode(faker.address().zipCode());
            address.setCity(faker.address().city());
            address.setState(faker.address().state());
            address.setCountry(faker.address().country());
            addressService.create(address);
        }
    }

    public void fakerFaculty() {
        Faker faker = new Faker();
        for (int i = 1; i < 250; i++) {
            Faculty faculty = new Faculty();
            faculty.setFirstname(faker.name().firstName());
            faculty.setLastname(faker.name().lastName());
            faculty.setTitle(faker.bothify("Professor"));
            faculty.setEmail(faker.bothify("????##@gmail.com"));
            facultyService.create(faculty);
        }
    }
    public void fakerRegistrationRequest() {
        Faker faker = new Faker();
        for (int i = 200; i < 250; i++) {
            RegistrationRequest registrationRequest= new RegistrationRequest();
          //  registrationRequest.setPriority(faker.number());

            registrationRequestService.create(registrationRequest);
        }
    }
}
