package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.Course;
import com.example.ea_final_project.model.Faculty;
import com.example.ea_final_project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseService service;
    @GetMapping("/courses")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Course> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Course findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Course create(@RequestBody Course course) {

        return service.create(course);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Course update(@PathVariable Integer id, @RequestBody Course course) {
        return service.update(id, course);
    }
}
