package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.AcademicBlock;
import com.example.ea_final_project.service.AcademicBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AcademicBlock")
public class AcademicBlockController {
    @Autowired
    AcademicBlockService service;

    @GetMapping
    public List<AcademicBlock> findAll() {

        return service.findAll();
    }

    @GetMapping("/{id}")
    public AcademicBlock findById(@PathVariable Integer id) {
        System.out.println(id);
        return service.findAll().get(0);
    }

    @PostMapping
    public AcademicBlock create(@RequestBody AcademicBlock academicBlock) {
        return service.create(academicBlock);
    }

    @PutMapping("/{id}")
    public AcademicBlock update(@PathVariable Integer id, @RequestBody AcademicBlock academicBlock) {

        AcademicBlock persistedAcademicBlock = service.findById(id);
        if (persistedAcademicBlock != null) {
            persistedAcademicBlock.setCode(academicBlock.getCode());
            persistedAcademicBlock.setName(academicBlock.getName());
            persistedAcademicBlock.setSemester(academicBlock.getSemester());
            persistedAcademicBlock.setStartDate(academicBlock.getStartDate());
            persistedAcademicBlock.setEnddate(academicBlock.getEnddate());
            return service.update(persistedAcademicBlock);
        }
        return academicBlock;

    }

}
