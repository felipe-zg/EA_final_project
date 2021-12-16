package com.example.ea_final_project.repository;

import com.example.ea_final_project.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select s from Student s where s.registrationGroup.id=:id")
    List<Student> getAllStudentsWithGroup(int id);
}
