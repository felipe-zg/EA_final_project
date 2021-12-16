package com.example.ea_final_project.service;

import com.example.ea_final_project.model.Faculty;
import com.example.ea_final_project.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService implements IFacultyService{
    @Autowired
    private FacultyRepository repository;

    @Override
    public List<Faculty> findAll() {
        return repository.findAll();
    }

    @Override
    public Faculty findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Faculty create(Faculty faculty) {
        return repository.save(faculty);
    }

    @Override
    public Faculty update(Integer id, Faculty faculty) {
        Faculty persistedFaculty = findById(faculty.getId());
        if (persistedFaculty != null) {
            persistedFaculty.setFirstname(faculty.getFirstname());
            persistedFaculty.setLastname(faculty.getLastname());
            persistedFaculty.setEmail(faculty.getEmail());
            persistedFaculty.setTitle(faculty.getTitle());
            return repository.save(persistedFaculty);
        }
        return faculty;
    }

}
