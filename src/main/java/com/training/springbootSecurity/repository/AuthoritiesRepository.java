package com.training.springbootSecurity.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springbootSecurity.entity.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {
	Set<Authorities> findByUsername(String name);
}