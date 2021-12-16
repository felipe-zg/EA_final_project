package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.AcademicBlock;
import com.example.ea_final_project.service.AcademicBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/academicblocks")
public class AcademicBlockController {
    @Autowired
    AcademicBlockService service;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<AcademicBlock> findAll() {

        return service.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public AcademicBlock findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public AcademicBlock create(@RequestBody AcademicBlock academicBlock) {
        return service.create(academicBlock);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public AcademicBlock update(@PathVariable Integer id, @RequestBody AcademicBlock academicBlock) {
        return service.update(id, academicBlock);

    }

}
