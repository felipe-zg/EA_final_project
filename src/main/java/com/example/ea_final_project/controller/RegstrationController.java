package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.Registration;
import com.example.ea_final_project.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegstrationController {

    @Autowired
    private RegistrationService service;

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public Collection<Registration> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Registration findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping("/saveRegistration")
    @PreAuthorize("hasRole('ADMIN')")
    public Registration create(@RequestBody Registration registration) {
        return service.create(registration);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Registration update(@PathVariable Integer id, @RequestBody Registration registration) {
        return service.update(id, registration);
    }
}
