package com.example.ea_final_project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class RegistrationGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String groupName;
    @Transient
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<AcademicBlock> blocks = new ArrayList<>();
    @ManyToMany

    private List<Student> students = new ArrayList<>();

    @ManyToMany
    private Collection<RegistrationEvent> registrationEvents = new ArrayList<>();

//    public void addStudent(Student student) {
//        if(!this.students.contains(student)) {
//            this.students.add(student);
//        }
//    }

//    public void addAcademicBlock(AcademicBlock block) {
//        if (!this.blocks.contains(block)) {
//            this.blocks.add(block);
//        }
//    }

}
