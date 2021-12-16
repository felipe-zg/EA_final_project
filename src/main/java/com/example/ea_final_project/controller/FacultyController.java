package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.Faculty;
import com.example.ea_final_project.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {
    @Autowired
    FacultyService service;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Faculty> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Faculty findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Faculty create(@RequestBody Faculty faculty) {
        return service.create(faculty);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Faculty update(@PathVariable Integer id, @RequestBody Faculty faculty) {
       return service.update(id, faculty);
    }
}
