package com.caner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.caner.entities.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
    @Transactional
    @Modifying
    @Query(value="UPDATE student  SET deleted = true WHERE id=:id",nativeQuery=true)
    void softDelete(@Param("id") Integer id);

    @Query(value="SELECT * FROM student WHERE deleted = false",nativeQuery=true)
    List<Student> findAllActiveStudents();
    
}
