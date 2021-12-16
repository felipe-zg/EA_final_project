package com.example.ea_final_project.service;

import com.example.ea_final_project.model.Faculty;
import com.example.ea_final_project.model.Student;
import com.example.ea_final_project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Student create(Student student) {
        return repository.save(student);
    }

    @Override
    public Student update(Integer id, Student student) {
        Student persistedStudent = findById(student.getId());
        if (persistedStudent != null) {
            persistedStudent.setStudentId(student.getStudentId());
            persistedStudent.setFirstname(student.getFirstname());
            persistedStudent.setLastname(student.getLastname());
            persistedStudent.setEmail(student.getEmail());
            return repository.save(persistedStudent);
        }
        return student;
    }

    @Override
    public List<Student> getStudentsByGroup(int id) {
        try {
            return repository.getAllStudentsWithGroup(id);

        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }

    }


}
