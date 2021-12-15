package com.example.ea_final_project.repository;

import java.util.Optional;

import com.example.ea_final_project.model.utils.ERole;
import com.example.ea_final_project.model.utils.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
