package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.CourseOffering;
import com.example.ea_final_project.model.Registration;
import com.example.ea_final_project.model.RegistrationRequest;
import com.example.ea_final_project.model.utils.Status;
import com.example.ea_final_project.service.CourseOfferingService;
import com.example.ea_final_project.service.RegistrationRequestService;
import com.example.ea_final_project.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController

@RequestMapping("/registrations")
public class RegstrationController {

    @Autowired
    private RegistrationService service;
    @Autowired
    CourseOfferingService courseOfferingService;
    @Autowired
    RegistrationRequestService registrationRequestService;

    @GetMapping()
    public Collection<Registration> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Registration findById(@PathVariable Integer id) {
        return service.findById(id);

    }

    @GetMapping("/student/{id}")
    public List<Registration> getRegistrationByStudentId(@PathVariable Integer id) {
        return service.getRegistrationByStudentId(id);
    }
    @PostMapping("/saveRegistration")
    public Registration create(@RequestBody Registration registration) {
        return service.create(registration);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PatchMapping()
    public Registration update(@PathVariable Integer id, @RequestBody Registration registration) {
        return service.update(id, registration);


    }

    @GetMapping("/process")
    public String processReqistrationRequest() {
        List<CourseOffering> courseOfferingList = courseOfferingService.findAll();
        for (CourseOffering co : courseOfferingList) {

            int capacity = co.getCapacity();
            List<RegistrationRequest> requests = service.getRegistrationRequestByCourseOfferingId(co.getId());
            Set<RegistrationRequest> selectedRequest = new HashSet<>();
            for (int i = 0; selectedRequest.size() < capacity && requests.size() > selectedRequest.size(); i++) {
                Random r = new Random();
                int s = r.nextInt(requests.size());
                selectedRequest.add(requests.get(s));
            }
            for (RegistrationRequest r : selectedRequest) {
                RegistrationRequest req = registrationRequestService.findById(r.getId());
                req.setStatus(Status.RGISTERED);
                registrationRequestService.update(req);
                Registration registration= new Registration();
                registration.setCourseOffering(co);
                registration.setStudent(r.getStudent());
                service.create(registration);
            }
        }

        return "Registered!!";

    }
}
