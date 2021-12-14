package com.example.ea_final_project.service;

import com.example.ea_final_project.model.RegistrationRequest;

import java.util.List;

public interface IRegistrationRequestService {
     List<RegistrationRequest> findAll();
     RegistrationRequest findById(Integer id) ;
     RegistrationRequest create(RegistrationRequest registrationRequest);
     RegistrationRequest update(RegistrationRequest request);
}
