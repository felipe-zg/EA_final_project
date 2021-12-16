package com.example.ea_final_project.model;

import com.example.ea_final_project.model.utils.Semester;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "block")
public class AcademicBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    @Enumerated
    private Semester semester;
    private LocalDate startDate;
    private LocalDate enddate;

    public AcademicBlock(String name, String code, Semester semester, LocalDate startDate, LocalDate enddate) {
        this.name = name;
        this.code = code;
        this.semester = semester;
        this.startDate = startDate;
        this.enddate = enddate;
    }
}
