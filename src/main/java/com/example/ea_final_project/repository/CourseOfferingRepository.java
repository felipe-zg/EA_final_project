package com.example.ea_final_project.repository;

import com.example.ea_final_project.model.CourseOffering;
import com.example.ea_final_project.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CourseOfferingRepository extends JpaRepository<CourseOffering, Integer> {
    @Query("from CourseOffering c where c.block.id=:id ")
    List<CourseOffering> getCourseOfferingByBlock(int id);
}
