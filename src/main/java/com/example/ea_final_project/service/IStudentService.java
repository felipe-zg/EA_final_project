package com.example.ea_final_project.service;

import com.example.ea_final_project.model.Faculty;
import com.example.ea_final_project.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> findAll();
    public Student findById(Integer id) ;
    public Student create(Student student);
    public Student update(Integer id, Student student);
    List<Student >getStudentsByGroup(int id);
}
