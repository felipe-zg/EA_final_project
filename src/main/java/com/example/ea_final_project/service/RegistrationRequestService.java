package com.example.ea_final_project.service;

import com.example.ea_final_project.model.RegistrationEvent;
import com.example.ea_final_project.model.RegistrationRequest;
import com.example.ea_final_project.repository.RegistrationEventRepository;
import com.example.ea_final_project.repository.RegistrationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegistrationRequestService implements IRegistrationRequestService {
@Autowired
    RegistrationRequestRepository repository;
    @Override
    public List<RegistrationRequest> findAll() {
        return repository.findAll();
    }

    @Override
    public RegistrationRequest findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public RegistrationRequest create(RegistrationRequest registrationRequest) {
        return repository.save(registrationRequest);
    }

    @Override
    public RegistrationRequest update(RegistrationRequest request) {
        return repository.save(request);
    }
}
