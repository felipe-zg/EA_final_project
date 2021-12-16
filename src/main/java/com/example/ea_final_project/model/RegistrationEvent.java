package com.example.ea_final_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class RegistrationEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToMany
    @JoinTable(
            joinColumns = {@JoinColumn(name = "RegistrationEvent_id")},
            inverseJoinColumns = {@JoinColumn(name = "RegistrationGroup_id")}
    )
    private List<RegistrationGroup> registrationGroups=new ArrayList<>();


}
