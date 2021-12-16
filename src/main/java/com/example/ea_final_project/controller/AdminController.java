package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.RegistrationEvent;
import com.example.ea_final_project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService service;

    @GetMapping
    public List<RegistrationEvent> findAll() {
        return service.findAll();
    }
    @GetMapping("/{id}")
    public RegistrationEvent findById(@PathVariable Integer id) {
        return service.findById(id);
    }
    @PostMapping
    public RegistrationEvent create(@RequestBody RegistrationEvent event) {
        return service.create(event);
    }

    @PatchMapping("/{id}")
    public RegistrationEvent update(@PathVariable Integer id, @RequestBody RegistrationEvent event) {
        RegistrationEvent persistedEvent = service.findById(event.getId());
        if (persistedEvent != null) {
            persistedEvent.setStartDate(event.getStartDate());
            persistedEvent.setEndDate(event.getEndDate());
            return service.update(persistedEvent);
        }
        return event;
    }
}
