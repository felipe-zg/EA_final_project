package com.example.ea_final_project.service;

import com.example.ea_final_project.model.AcademicBlock;

import java.util.List;

public interface IAcademicBlockService {
     AcademicBlock create(AcademicBlock academicBlock);
     List<AcademicBlock> findAll();
     AcademicBlock findById(Integer id) ;
     AcademicBlock update(AcademicBlock academicBlock);
}
