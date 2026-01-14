package com.caner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caner.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
