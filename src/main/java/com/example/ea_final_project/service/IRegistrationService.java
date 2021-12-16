package com.example.ea_final_project.service;

import com.example.ea_final_project.model.Registration;
import com.example.ea_final_project.model.RegistrationRequest;

import java.util.Collection;
import java.util.List;

public interface IRegistrationService {
    public Registration create(Registration registration);

    public Registration findById(Integer id);

    public Collection<Registration> findAll();

    public Registration update(Integer id, Registration registration);

    public void deleteById(Integer id);
//    List<RegistrationRequest> getRegistrationRequestByCourseOfferingId(int id);
//    List<Registration> getRegistrationByStudentId(int id);


}