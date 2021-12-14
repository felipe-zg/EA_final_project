package com.example.ea_final_project.service;

import com.example.ea_final_project.model.AcademicBlock;
import com.example.ea_final_project.repository.AcademicBlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicBlockService implements IAcademicBlockService{
    @Autowired
    private AcademicBlockRepository repository;


    @Override
    public AcademicBlock create(AcademicBlock academicBlock) {
        return repository.save(academicBlock);
    }

    @Override
    public List<AcademicBlock> findAll() {
        return repository.findAll();
    }

    @Override
    public AcademicBlock findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AcademicBlock update(AcademicBlock academicBlock) {
        return repository.save(academicBlock);
    }
}
