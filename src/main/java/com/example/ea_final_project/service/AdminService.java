package com.example.ea_final_project.service;

import com.example.ea_final_project.model.RegistrationEvent;
import com.example.ea_final_project.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminService implements  IAdminService{
    @Autowired
    AdminRepository repository;
    @Override
    public RegistrationEvent create(RegistrationEvent event) {
        return repository.save(event);
    }

    @Override
    public List <RegistrationEvent> findAll() {
        return repository.findAll();
    }

    @Override
    public RegistrationEvent findById(Integer id) {
        return repository.findById(id).orElse(null);
    }


    @Override
    public void deleteById(Integer eventId) {
     repository.deleteById(eventId);
    }

    @Override
    public RegistrationEvent update(RegistrationEvent event) {
        return repository.save(event);
    }
}
