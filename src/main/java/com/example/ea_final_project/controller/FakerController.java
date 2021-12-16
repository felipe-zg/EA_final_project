package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.*;
import com.example.ea_final_project.model.utils.Semester;
import com.example.ea_final_project.model.utils.Status;
import com.example.ea_final_project.service.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;


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
    // @Autowired
    //AddressService addressService;
    @Autowired
    CourseOfferingService courseOfferingService;
    @Autowired
    RegistrationService registrationService;
    @Autowired
    RegistrationEventService registrationEventService;
    @Autowired
    RegistrationRequestService registrationRequestService;
    @Autowired
    AcademicBlockService academicBlockService;

    @GetMapping
    public void addData() {
        fakerAcademicBlock();
        fakerCourse();
        fakerFaculty();
        fakerRegistrationGroup();
        fakerRegistrationEvent();

        fakerStudent();
        fakerCourseOffering();
        fakerRegistrationRequest();
        // fakerRegistrationRequest1();
    }

    public void fakerRegistrationGroup() {
        String[] entry = {"MAY", "AUG", "NOV", "FEB"};
        List<Student> students = studentService.findAll();
        List<AcademicBlock> acadamicBlocks = academicBlockService.findAll();
        // List<RegistrationEvent> registrationEvents = registrationEventService.findAll();

        for (int i = 0; i < entry.length; i++) {
            RegistrationGroup regGroup = new RegistrationGroup();
            regGroup.setGroupName(entry[i] + " " + LocalDate.now().getYear());
            regGroup.setBlocks(acadamicBlocks);
            registrationGroupService.create(regGroup);
        }
    }

    public void fakerRegistrationEvent() {
        List<RegistrationGroup> groups = registrationGroupService.findAll();
        Faker faker = new Faker();
        for (int i = 1; i < 5; i++) {
            RegistrationEvent event = new RegistrationEvent();
            event.setStartDate(LocalDate.from(LocalDateTime.now()));
            event.setEndDate(LocalDate.now().plusDays(15));
            event.setRegistrationGroups(groups);
            registrationEventService.create(event);
        }
        for (int i = 1; i < 5; i++) {
            RegistrationEvent event2 = new RegistrationEvent();
            event2.setStartDate(LocalDate.now().plusDays(20));
            event2.setEndDate(LocalDate.now().plusMonths(1));
            event2.setRegistrationGroups(groups);
            registrationEventService.create(event2);
        }
    }

    public void fakerCourse() {
        String[] names = {"Fundamnetal of Progarmming Practice", "Modern Programming Practice", "Web Application Programming", "Enterprise Archtecture", "Modern Web Application", "Big Data Technology", "Software Architcture",};
        String[] codes = {"CS390", "CS400", "CS544", "CS577", "CS425", "CS572",};
        for (int i = 0; i < 6; i++) {
            Course course = new Course();
            course.setName(names[i]);
            course.setCode(codes[i]);
            course.setDescription(" description here...");
            courseService.create(course);
        }
    }

    public void fakerStudent() {
        Faker faker = new Faker();
        List<RegistrationGroup> registrationGroups = registrationGroupService.findAll();
        System.out.println("group siz= " + registrationGroups.size());
        for (int i = 50; i < 150; i++) {
            Address homeAddress = new Address();
            homeAddress.setCity(faker.address().city());
            homeAddress.setPostalCode(faker.address().zipCode());
            homeAddress.setStreet(faker.address().streetAddress());
            homeAddress.setState(faker.address().state());
            homeAddress.setCountry(faker.address().country());


            Address billingAddress = new Address();
            billingAddress.setCity(faker.address().city());
            billingAddress.setPostalCode(faker.address().zipCode());
            billingAddress.setStreet(faker.address().streetAddress());
            billingAddress.setState(faker.address().state());
            billingAddress.setCountry(faker.address().country());

            Student student = new Student();
            student.setFirstname(faker.name().firstName());
            student.setLastname(faker.name().lastName());
            student.setPassword(faker.name().firstName());
            student.setStudentId("61-12" + i);
            student.setHomeAddress(homeAddress);
            student.setBillingAddress(billingAddress);

            RegistrationGroup group = new RegistrationGroup();
            group.setId((i % 4) + 1);
            System.out.println("=================================" + group.getId());
            student.setRegistrationGroup(group);
            // student.getBillingAddress();
            //student.setHomeAddress(addresses);
            student.setEmail(faker.bothify("????##@gmail.com"));
            studentService.create(student);
        }
    }

//    public void fakerAddress() {
//        Faker faker = new Faker();
//        Student student= new Student();
//        for (int i = 1; i < 100; i++) {
//           // Address address = new Address();
//            student.setHomeAddress(faker.address().streetAddress());
//            address.setPostalCode(faker.address().zipCode());
//            address.setCity(faker.address().city());
//            address.setState(faker.address().state());
//            address.setCountry(faker.address().country());
//            addressService.create(address);
//        }
//    }

    public void fakerFaculty() {
        Faker faker = new Faker();
        for (int i = 1; i < 10; i++) {
            Faculty faculty = new Faculty();
            faculty.setFirstname(faker.name().firstName());
            faculty.setLastname(faker.name().lastName());
            faculty.setTitle(faker.bothify("Professor"));
            faculty.setEmail(faker.bothify("????##@gmail.com"));
            facultyService.create(faculty);
        }
    }

    public void fakerRegistrationRequest1() {
        List<RegistrationGroup> groups = registrationGroupService.findAll();
        int i = 0;
        for (RegistrationGroup g : groups) {
            List<Student> students = studentService.getStudentsByGroup(g.getId());
            i++;
            for (Student student : students) {
                RegistrationRequest req = new RegistrationRequest();
                req.setPriority(i);
                req.setStatus(Status.WAITING);
                //  req.setCourseOffering(courseOffering);
                req.setStudent(student);
                registrationRequestService.create(req);
            }
//
//            for (Student s : students) {
//                for (AcademicBlock ac : g.getBlocks()) {
//                    List<CourseOffering> courseOfferings = courseOfferingService.getCourseOfferingByBlock(ac.getId());
//                    for (CourseOffering co:courseOfferings) {
//                        System.out.println(co.toString());
//                    }
//                    for (int i = 0; i < courseOfferings.size(); i++) {
//                        RegistrationRequest request = new RegistrationRequest();
//                        request.setPriority(i + 1);
//                        request.setCourseOffering(courseOfferings.get(i));
//                        request.setStudent(s);
//                        //  registrationRequestService.create(request);
//                    }
//                }
//            }
        }
    }

    public void fakerRegistrationRequest() {
        List<RegistrationGroup> groups = registrationGroupService.findAll();
        System.out.println("Sizeof Group==" + groups.size());
        for (RegistrationGroup g : groups) {
            System.out.println("ID====" + g.getId());
            List<Student> students = studentService.getStudentsByGroup(g.getId());
            System.out.println("Sizeof students==" + students.size());

            for (Student s : students) {
                for (AcademicBlock ac : g.getBlocks()) {
                    List<CourseOffering> courseOfferings = courseOfferingService.getCourseOfferingByBlock(ac.getId());
                    System.out.println("Sizeof courseOfferings==" + courseOfferings.size());

                    for (int i = 0; i < courseOfferings.size(); i++) {
                        RegistrationRequest request = new RegistrationRequest();
                        int priority=i+1;
                        request.setPriority(priority);
                        System.out.println("PRIORITY=="+priority);
                        request.setStatus(Status.WAITING);
                        request.setCourseOffering(courseOfferings.get(i));
                        request.setStudent(s);
                        System.out.println("Creating ==" + s.getFirstname() + " ===>" + courseOfferings.get(i).getCode());
                       registrationRequestService.create(request);
                    }
                }
            }
        }
//        for (int i = 200; i < 250; i++) {
//            RegistrationRequest registrationRequest= new RegistrationRequest();
//          // registrationRequest.setPriority(faker);
//            registrationRequestService.create();
//        }
    }

    public void fakerCourseOffering() {

        List<Course> courses = courseService.findAll();
        List<Faculty> faculties = facultyService.findAll();
        List<AcademicBlock> academicBlocks = academicBlockService.findAll();
       // List<Student> students = studentService.findAll();
        for (int i = 0; i < academicBlocks.size(); i++) {
            List <RegistrationRequest> registrationRequests= registrationRequestService.findAll();
            for (int j = 0; j < courses.size(); j++) {
                Random r = new Random();
                int k = r.nextInt(faculties.size());
              //  for (int k = 0; k < faculties.size(); k++) {
                    String facultyName = "" + faculties.get(k).getFirstname().charAt(0)
                            + faculties.get(k).getLastname().charAt(0);
                    String courseCode = courses.get(j).getCode();
                    CourseOffering courseOffering = new CourseOffering();
                    courseOffering.setCode(courseCode + "-" + academicBlocks.get(i).getCode() + "-" + facultyName);
                    courseOffering.setFaculty(faculties.get(k));
                    courseOffering.setCourse(courses.get(j));
                    courseOffering.setBlock(academicBlocks.get(i));
                    courseOffering.setRegistrationsRequests(registrationRequests);
                    courseOffering.setCapacity(30);
                   // RegistrationRequest request = new RegistrationRequest();
                    courseOfferingService.create(courseOffering);

            }

        }
//        int i = 0;
//        for (Course course : courses) {
//            Random r = new Random();
//            int academicRandom = r.nextInt(academicBlocks.size());
//            int facultyRandom = r.nextInt(faculties.size());
//            String facultyName = "" + faculties.get(facultyRandom).getFirstname().charAt(0) + faculties.get(facultyRandom).getLastname().charAt(0);
//            String courseCode = course.getCode();
//            CourseOffering courseOffering = new CourseOffering();
//            courseOffering.setCode(courseCode + "-" + academicBlocks.get(academicRandom).getCode() + "-" + facultyName);
//            courseOffering.setFaculty(faculties.get(facultyRandom));
//            courseOffering.setCourse(course);
//            courseOffering.setBlock(academicBlocks.get(academicRandom));
//            courseOffering.setCapacity(30);
//            RegistrationRequest request = new RegistrationRequest();
            // courseOffering.setRegistrationsRequests();
//            i++;
//            // RegistrationRequest req = new RegistrationRequest();
//            courseOfferingService.create(courseOffering);
//            for (Student student : students) {
//                RegistrationRequest req = new RegistrationRequest();
//                req.setPriority(i);
//                req.setStatus(Status.WAITING);
//                //  req.setCourseOffering(courseOffering);
//                req.setStudent(student);
//                registrationRequestService.create(req);
//            }
            //  courseOffering.addRegistrationRequests(req);
            //  courseOffering.setRegistrationsRequests(req);
            // courseOfferingService.create(courseOffering);
      //  }
    }

    public void fakerAcademicBlock() {
        String[] acadamicBlocks = {"NOVEMBER", "DECEMBER", "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER"};
        Semester[] semester = {Semester.WINTER, Semester.SPRING, Semester.SUMMER};
        Faker faker = new Faker();
        int k = 0;
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 4; i++) {
                String name = faker.expression(acadamicBlocks[k] + " " + "2021 ");
                AcademicBlock academicBlock = new AcademicBlock();
                academicBlock.setCode("2021-12A-12D");
                academicBlock.setName(name);
                academicBlock.setEnddate(LocalDate.now().plusDays(15));
                academicBlock.setStartDate(LocalDate.now());
                academicBlock.setSemester(semester[j]);
                academicBlockService.create(academicBlock);
                k++;
            }
        }


    }


}

