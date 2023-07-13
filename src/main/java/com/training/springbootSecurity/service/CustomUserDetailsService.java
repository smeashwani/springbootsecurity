package com.training.springbootSecurity.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.springbootSecurity.entity.User;
import com.training.springbootSecurity.repository.AuthoritiesRepository;
import com.training.springbootSecurity.repository.UserRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepo userRepository;
    
    private AuthoritiesRepository authoritiesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

        
        Set<GrantedAuthority> authorities = authoritiesRepository.findByUsername(username).stream()
                .map((role) -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
        		username,
                user.getPassword(),
                authorities
        );
    }
}