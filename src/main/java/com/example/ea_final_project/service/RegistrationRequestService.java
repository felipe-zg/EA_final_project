package com.example.ea_final_project.service;

import com.example.ea_final_project.model.CourseOffering;
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
    public RegistrationRequest update(Integer id, RegistrationRequest request) {
        RegistrationRequest persistedRequest = findById(request.getId());
        if (persistedRequest != null) {
            persistedRequest.setPriority(request.getPriority());
            return repository.save(persistedRequest);
        }
        return request;
    }

    @Override
    public RegistrationRequest getRegistrationRequestById(int id) {
        return repository.getRegistrationRequestById(id);
    }


    @Override
    public List<RegistrationRequest> getRegistrationRequestBySdudentId(int id) {
        return repository.getRegistrationRequestBySdudentId(id);
    }

    @Override
    public List<RegistrationRequest> getRegistrationRequestByStudentIdAndBlockId(int studentId, int blockId) {
        return repository.getRegistrationRequestByStudentIdAndBlockId(studentId,blockId);
    }
}
