package com.example.ea_final_project.service;

import com.example.ea_final_project.model.Course;
import com.example.ea_final_project.model.CourseOffering;

import java.util.List;

public interface ICourseOfferingService {
     CourseOffering create(CourseOffering courseOffering);
     List<CourseOffering> findAll();
     CourseOffering findById(Integer id) ;
     CourseOffering update(CourseOffering course);
}
