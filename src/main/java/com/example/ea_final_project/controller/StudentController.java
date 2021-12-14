package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.Faculty;
import com.example.ea_final_project.model.Student;
import com.example.ea_final_project.service.FacultyService;
import com.example.ea_final_project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping
    public List<Student> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.create(student);
    }

    @PatchMapping("/{id}")
    public Student update(@PathVariable Integer id, @RequestBody Student student) {
        Student persistedStudent = service.findById(student.getId());
        if (persistedStudent != null) {
            persistedStudent.setStudentId(student.getStudentId());
            persistedStudent.setFirstname(student.getFirstname());
            persistedStudent.setLastname(student.getLastname());
            persistedStudent.setEmail(student.getEmail());
            return service.update(persistedStudent);
        }
        return student;
    }
}
