package com.example.ea_final_project.service;

import com.example.ea_final_project.model.CourseOffering;
import com.example.ea_final_project.model.Student;
import com.example.ea_final_project.repository.CourseOfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseOfferingService implements ICourseOfferingService{
    @Autowired
    private CourseOfferingRepository repository;

    @Override
    public CourseOffering create(CourseOffering courseOffering) {
        return repository.save(courseOffering);
    }

    @Override
    public List<CourseOffering> findAll() {
        return repository.findAll();
    }

    @Override
    public CourseOffering findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CourseOffering update(Integer id, CourseOffering courseOffer) {
        CourseOffering persistedCourseOffer = findById(courseOffer.getId());
        if (persistedCourseOffer != null) {
            persistedCourseOffer.setCode(courseOffer.getCode());
            persistedCourseOffer.setCapacity(courseOffer.getCapacity());
            persistedCourseOffer.setCourse(courseOffer.getCourse());
            persistedCourseOffer.setBlock(courseOffer.getBlock());
            persistedCourseOffer.setFaculty(courseOffer.getFaculty());
            // persistedCourseOffer.setAvailableSeats(courseOffer.getAvailableSeats());
            return repository.save(persistedCourseOffer);
        }

        return  courseOffer;
    }

    @Override
    public List<CourseOffering> getCourseOfferingByBlock(int id) {
        return repository.getCourseOfferingByBlock(id);
    }


}
