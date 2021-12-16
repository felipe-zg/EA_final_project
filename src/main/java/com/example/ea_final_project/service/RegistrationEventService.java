package com.example.ea_final_project.service;

import com.example.ea_final_project.model.RegistrationEvent;
import com.example.ea_final_project.repository.RegistrationEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationEventService implements IRegistrationEventService{
    @Autowired
    RegistrationEventRepository eventRepository;
    @Override
    public List<RegistrationEvent> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public RegistrationEvent findById(Integer id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public RegistrationEvent create(RegistrationEvent registrationEvent) {
        return eventRepository.save(registrationEvent);
    }

    @Override
    public RegistrationEvent update(Integer id, RegistrationEvent registrationEvent) {
        RegistrationEvent persistedEvent = findById(registrationEvent.getId());
        if (persistedEvent != null) {
            if (registrationEvent.getStartDate() != null){
                persistedEvent.setStartDate(registrationEvent.getStartDate());
            }
            if(registrationEvent.getEndDate()!=null){
                persistedEvent.setEndDate(registrationEvent.getEndDate());
            }
            return repository.save(persistedEvent);
        }
        return registrationEvent;
    }

    @Override
    public void deleteById(Integer eventId) {
        eventRepository.deleteById(eventId);
    }
    @Autowired
    RegistrationEventRepository repository;


    public List<RegistrationEvent> getLatestRegistationEvents(String studId) {
        return repository.getLatestRegistationEvents(studId);
    }
    @Override
    public RegistrationEvent findFirstEvent(){
        return repository.findEventOrderByStartDateDesc();
    }
}
