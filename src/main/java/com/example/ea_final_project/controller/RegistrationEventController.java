package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.Faculty;
import com.example.ea_final_project.model.RegistrationEvent;
import com.example.ea_final_project.service.RegistrationEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/registration-events/latest")
public class RegistrationEventController {
    @Autowired
    RegistrationEventService service;

    public class RegistrationEventComparator implements Comparator<RegistrationEvent> {
        @Override
        public int compare(RegistrationEvent o1, RegistrationEvent o2) {
            return o2.getStartDate().compareTo(o1.getStartDate());
        }
    }

    @GetMapping
    public List<RegistrationEvent> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RegistrationEvent findById(@PathVariable Integer id) {
        List<RegistrationEvent> events = service.findAll();
        Collections.sort(events, new RegistrationEventComparator());
        return events.get(0);
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
