package com.example.ea_final_project.service;

import com.example.ea_final_project.model.Registration;
import com.example.ea_final_project.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RegistrationService implements IRegistrationService{
    @Autowired
    private RegistrationRepository repository;


    @Override
    public Registration create(Registration registration) {
        return repository.save(registration);
    }

    @Override
    public Registration findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<Registration> findAll() {
        return repository.findAll();
    }

    @Override
    public Registration update(Integer id, Registration registration) {
        return repository.save(registration);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
