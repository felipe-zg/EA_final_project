package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.RegistrationEvent;
import com.example.ea_final_project.model.RegistrationRequest;
import com.example.ea_final_project.service.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrationrequests")
public class RegistrationRequestController {
    @Autowired
    RegistrationRequestService service;

    @GetMapping
    public List<RegistrationRequest> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RegistrationRequest findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public RegistrationRequest create(@RequestBody RegistrationRequest registrationRequest) {
        return service.create(registrationRequest);
    }

    @PutMapping("/{id}")
    public RegistrationRequest update(@PathVariable Integer id, @RequestBody  RegistrationRequest request) {
        RegistrationRequest persistedRequest = service.findById(request.getId());
        if (persistedRequest != null) {
            persistedRequest.setPriority(request.getPriority());
            return service.update(persistedRequest);
        }
        return request;
    }
}
