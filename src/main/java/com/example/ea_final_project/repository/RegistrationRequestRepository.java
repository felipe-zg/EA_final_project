package com.example.ea_final_project.repository;

import com.example.ea_final_project.model.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest,Integer> {
}
