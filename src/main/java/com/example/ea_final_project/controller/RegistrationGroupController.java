package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.RegistrationGroup;
import com.example.ea_final_project.service.RegistrationGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/registrationGroups")
public class RegistrationGroupController {

    @Autowired
    private RegistrationGroupService service;

    @GetMapping()
    public List<RegistrationGroup> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RegistrationGroup findById(@PathVariable Integer id) {
        return service.findById(id);

    }
    @PostMapping
    public RegistrationGroup create(@RequestBody RegistrationGroup registrationGroup) {
        return service.create(registrationGroup);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
    @PutMapping("/{id}")
    public RegistrationGroup update(@PathVariable Integer id, @RequestBody RegistrationGroup registrationGroup){
        return service.update(id,registrationGroup);


    }
}
