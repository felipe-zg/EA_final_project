package com.example.ea_final_project.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface PersonDetailsService {
    UserDetails loadPersonByEmail(String email) throws UsernameNotFoundException;
}
