package com.example.ea_final_project.service;

import com.example.ea_final_project.model.Registration;
import com.example.ea_final_project.model.RegistrationRequest;
import com.example.ea_final_project.model.Student;
import com.example.ea_final_project.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

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
        Registration persistedResgistration = findById(registration.getId());
        if (persistedResgistration != null) {
            persistedResgistration.setCourseOffering(registration.getCourseOffering());
            persistedResgistration.setStudent(registration.getStudent());
            return repository.save(persistedResgistration);
        }
        return registration;
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

//    @Override
//    public List<RegistrationRequest> getRegistrationRequestByCourseOfferingId(int id) {
//        return repository.getRegistrationRequestByCourseOfferingId(id);
//    }
//
//    @Override
//    public List<Registration> getRegistrationByStudentId(int id) {
//        return repository.getRegistrationByStudentId(id);
//    }

}
