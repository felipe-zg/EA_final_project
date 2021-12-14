package com.example.ea_final_project.service;

import com.example.ea_final_project.model.Course;
import com.example.ea_final_project.model.Faculty;

import java.util.List;

public interface ICourseService {
     Course create(Course course);
     List<Course> findAll();
     Course findById(Integer id) ;
     Course update(Course course);
}
