package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.Course;
import com.example.ea_final_project.model.Faculty;
import com.example.ea_final_project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService service;
    @GetMapping
    public List<Course> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Course create(@RequestBody Course course) {

        return service.create(course);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Integer id, @RequestBody Course course) {
        Course persistedCourse = service.findById(course.getId());
        if (persistedCourse != null) {
            persistedCourse.setName(course.getName());
            persistedCourse.setCode(course.getCode());
            persistedCourse.setDescription(course.getDescription());
            return service.update(persistedCourse);
        }

        return  course;
    }
}
