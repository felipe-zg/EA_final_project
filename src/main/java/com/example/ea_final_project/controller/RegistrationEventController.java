package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.Faculty;
import com.example.ea_final_project.model.RegistrationEvent;
import com.example.ea_final_project.service.RegistrationEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrationevents")
public class RegistrationEventController {
    @Autowired
    RegistrationEventService service;

    @GetMapping
    public List<RegistrationEvent> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RegistrationEvent findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public RegistrationEvent create(@RequestBody RegistrationEvent registrationEvent) {
        return service.create(registrationEvent);
    }

    @PatchMapping("/{id}")
    public RegistrationEvent update(@PathVariable Integer id, @RequestBody RegistrationEvent registrationEvent) {
        RegistrationEvent persistedEvent = service.findById(registrationEvent.getId());
        if (persistedEvent != null) {
            persistedEvent.setStartDate(registrationEvent.getStartDate());
            persistedEvent.setEndDate(registrationEvent.getEndDate());
            return service.update(persistedEvent);
        }
        return registrationEvent;
    }
}
