package com.example.ea_final_project.service;

import com.example.ea_final_project.model.RegistrationGroup;
import com.example.ea_final_project.repository.RegistrationGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IRegistrationGroupService {
     RegistrationGroup create(RegistrationGroup group);
    RegistrationGroup findById(Integer id);
    List<RegistrationGroup> findAll();

    RegistrationGroup update(Integer id, RegistrationGroup registrationGroup);

    void deleteById(Integer id);
}
