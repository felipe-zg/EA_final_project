package com.example.ea_final_project.repository;

import com.example.ea_final_project.model.RegistrationEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<RegistrationEvent,Integer> {

}
