package com.caner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caner.entities.Role;
import com.caner.enums.ERole;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(ERole name);
}
