package com.example.ea_final_project.repository;

import com.example.ea_final_project.model.RegistrationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RegistrationEventRepository extends JpaRepository<RegistrationEvent,Integer> {
}
