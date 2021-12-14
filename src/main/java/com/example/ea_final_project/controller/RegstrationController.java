package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.Registration;
import com.example.ea_final_project.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegstrationController {

    @Autowired
    private RegistrationService service;

    @GetMapping()
    public Collection<Registration> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Registration findById(@PathVariable Integer id) {
        return service.findById(id);

    }

    @PostMapping("/saveRegistration")
    public Registration create(@RequestBody Registration registration) {
        return service.create(registration);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public Registration update(@PathVariable Integer id, @RequestBody Registration registration) {
        return service.update(id, registration);


    }
}
