package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.RegistrationEvent;
import com.example.ea_final_project.model.RegistrationRequest;
import com.example.ea_final_project.model.utils.Status;
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

    @GetMapping("/student/{id}")
    public List<RegistrationRequest> findAllByStudentId(@PathVariable int id) {
        return service.getRegistrationRequestBySdudentId(id);
    }
    @GetMapping("/student/{studentId}/block/{blockId}")
    public List<RegistrationRequest> findAllByStudentIdAndBlockId(@PathVariable int studentId, @PathVariable int blockId) {
        return service.getRegistrationRequestByStudentIdAndBlockId(studentId,blockId);
    }
    @PutMapping("/student/{studentId}/block/{blockId}")
    public List<RegistrationRequest> editPriorityByStudentIdAndBlockId(@RequestBody List<RegistrationRequest> requests,
                                                                       @PathVariable int studentId, @PathVariable int blockId) {
             for (RegistrationRequest req:requests
             ) {
            RegistrationRequest newReq=service.findById(req.getId());
            newReq.setPriority(req.getPriority());
            newReq.setStatus(Status.SAVED);
                 System.out.println("Changing Priority  from="+newReq.getPriority()+"  to "+req.getPriority());
            service.update(newReq);
        }
        return service.getRegistrationRequestByStudentIdAndBlockId(studentId,blockId);
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
