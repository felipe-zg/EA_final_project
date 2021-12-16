package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.RegistrationEvent;
import com.example.ea_final_project.model.RegistrationRequest;
import com.example.ea_final_project.model.utils.Status;
import com.example.ea_final_project.service.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrationrequests")
public class RegistrationRequestController {
    @Autowired
    RegistrationRequestService service;

    @GetMapping
    @PreAuthorize("hasRole('STUDENT') or hasRole('ADMIN')")
    public List<RegistrationRequest> findAll() {
        return service.findAll();
    }

    @GetMapping("/student/{id}")
    @PreAuthorize("hasRole('STUDENT')")
    public List<RegistrationRequest> findAllByStudentId(@PathVariable int id) {
        return service.getRegistrationRequestBySdudentId(id);
    }
    @GetMapping("/student/{studentId}/block/{blockId}")
    @PreAuthorize("hasRole('STUDENT') or hasRole('ADMIN')")
    public List<RegistrationRequest> findAllByStudentIdAndBlockId(@PathVariable int studentId, @PathVariable int blockId) {
        return service.getRegistrationRequestByStudentIdAndBlockId(studentId,blockId);
    }
    @PutMapping("/student/{studentId}/block/{blockId}")
    @PreAuthorize("hasRole('STUDENT')")
    public List<RegistrationRequest> editPriorityByStudentIdAndBlockId(@RequestBody List<RegistrationRequest> requests,
                                                                       @PathVariable int studentId, @PathVariable int blockId) {
             for (RegistrationRequest req:requests
             ) {
            RegistrationRequest newReq=service.findById(req.getId());
            newReq.setPriority(req.getPriority());
            newReq.setStatus(Status.SAVED);
                 System.out.println("Changing Priority  from="+newReq.getPriority()+"  to "+req.getPriority());
            service.update(newReq.getId(), newReq);
        }
        return service.getRegistrationRequestByStudentIdAndBlockId(studentId,blockId);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('STUDENT')")
    public RegistrationRequest findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('STUDENT')")
    public RegistrationRequest create(@RequestBody RegistrationRequest registrationRequest) {
        return service.create(registrationRequest);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('STUDENT')")
    public RegistrationRequest update(@PathVariable Integer id, @RequestBody  RegistrationRequest request) {
        return service.update(id, request);
    }
}
