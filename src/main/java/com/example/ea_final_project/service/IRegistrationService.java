package com.example.ea_final_project.service;

import com.example.ea_final_project.model.Registration;

import java.util.Collection;

public interface IRegistrationService {
    public Registration create(Registration registration);

    public Registration findById(Integer id);

    public Collection<Registration> findAll();

    public Registration update(Integer id, Registration registration);

    public void deleteById(Integer id);
}