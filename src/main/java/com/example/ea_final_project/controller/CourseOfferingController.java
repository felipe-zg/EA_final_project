package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.Course;
import com.example.ea_final_project.model.CourseOffering;
import com.example.ea_final_project.service.CourseOfferingService;
import com.example.ea_final_project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/courseofferings")
public class CourseOfferingController {
    @Autowired
    CourseOfferingService service;
    @GetMapping
    public List<CourseOffering> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CourseOffering findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public CourseOffering create(@RequestBody CourseOffering course) {

        return service.create(course);
    }

    @PutMapping("/{id}")
    public CourseOffering update(@PathVariable Integer id, @RequestBody CourseOffering courseOffer) {
        CourseOffering persistedCourseOffer = service.findById(courseOffer.getId());
        if (persistedCourseOffer != null) {
            persistedCourseOffer.setCode(courseOffer.getCode());
            persistedCourseOffer.setCapacity(courseOffer.getCapacity());
            persistedCourseOffer.setCourse(courseOffer.getCourse());
            persistedCourseOffer.setBlock(courseOffer.getBlock());
            persistedCourseOffer.setAvailableSeats(courseOffer.getAvailableSeats());
            return service.update(persistedCourseOffer);
        }

        return  courseOffer;
    }
}
