package com.caner.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message="Name cannot be null")
    @Column(name= "first_name")
    private String firstName;

    @NotEmpty(message="Last name cannot be empty")
    @Column(name="last_name")
    private String lastName;
    
    @NotBlank(message="Birth of date cannot be blank")
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="birth_of_date")
    private String birthOfDate;
    
    @Column(name="age")
    @Min(value= 18,message="Age should be >18")
    @Max(value=60,message="Age should be <60")
    private Integer age;

    @Size(min=6,max=20,message="Password must be greater than equal to 6 and less than equal to 20")
    @Column(name="password")
    private String password;
}
