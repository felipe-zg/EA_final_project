package com.example.ea_final_project.service;

import com.example.ea_final_project.model.RegistrationEvent;

import java.util.List;

public interface IAdminService {
    RegistrationEvent create(RegistrationEvent event);
    List<RegistrationEvent> findAll();
    RegistrationEvent findById(Integer id);
    void deleteById(Integer eventId);
    RegistrationEvent update(RegistrationEvent event);


}
