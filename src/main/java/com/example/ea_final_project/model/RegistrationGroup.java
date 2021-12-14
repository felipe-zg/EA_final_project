package com.example.ea_final_project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
public class RegistrationGroup {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Collection<AcademicBlock> blocks = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Collection<Student> students = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Collection<RegistrationEvent> registrationEvents = new ArrayList<>();

    public void addStudent(Student student) {
        if(!this.students.contains(student)) {
            this.students.add(student);
        }
    }

    public void addAcademicBlock(AcademicBlock block) {
        if (!this.blocks.contains(block)) {
            this.blocks.add(block);
        }
    }

    }
