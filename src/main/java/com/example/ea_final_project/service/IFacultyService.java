package com.example.ea_final_project.service;

import com.example.ea_final_project.model.Faculty;

import java.util.List;

public interface IFacultyService {
    public List<Faculty> findAll();
    public Faculty findById(Integer id) ;
    public Faculty create(Faculty faculty);
    public Faculty update(Integer id, Faculty faculty);
}
