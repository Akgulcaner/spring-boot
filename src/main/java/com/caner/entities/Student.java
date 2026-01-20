package com.caner.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="birth_of_date")
    private String birthOfDate;
    
    @Column(name="age")
    private Integer age;

    @Column(name="password")
    private String password;

    @Column(name="deleted")
    private boolean deleted =false;

    @ManyToMany
    @JoinTable(name="student_course",
            joinColumns= @JoinColumn(name="studentId"),
            inverseJoinColumns=@JoinColumn(name="courseId")
    )
    private List<Course> courses;
}
