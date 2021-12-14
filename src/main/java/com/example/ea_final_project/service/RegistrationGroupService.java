package com.example.ea_final_project.service;

import com.example.ea_final_project.model.RegistrationGroup;
import com.example.ea_final_project.repository.RegistrationGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RegistrationGroupService implements IRegistrationGroupService{
    @Autowired
     RegistrationGroupRepository repository;

    @Override
    public RegistrationGroup create(RegistrationGroup group) {
        return repository.save(group);
    }

    @Override
    public RegistrationGroup findById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public List<RegistrationGroup> findAll() {
        return repository.findAll();
    }

    @Override
    public RegistrationGroup update(Integer id, RegistrationGroup registrationGroup) {
        RegistrationGroup persistedGroup= repository.getById(registrationGroup.getId());
      // registrationGroup.setStudents(registrationGroup.getStudents());
        persistedGroup.setBlocks(registrationGroup.getBlocks());
        return repository.save(registrationGroup);
    }

    @Override
    public void deleteById(Integer id) {
      repository.deleteById(id);

    }
}
