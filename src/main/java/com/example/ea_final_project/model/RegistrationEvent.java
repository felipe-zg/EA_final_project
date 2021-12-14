package com.example.ea_final_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class RegistrationEvent {
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "RegistrationEvent_id")},
            inverseJoinColumns = {@JoinColumn(name = "RegistrationGroup_id")}
    )
    private Collection<RegistrationGroup> registrationGroups=new ArrayList<>();


}
