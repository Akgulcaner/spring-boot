package com.caner.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {

    @NotNull(message="Name cannot be null")
    private String firstName;

    @NotEmpty(message="Last name cannot be empty")
    private String lastName;

     @Min(value= 18,message="Age should be >18")
    @Max(value=60,message="Age should be <60")
    private Integer age;

    @Size(min=6,max=20,message="Password must be greater than equal to 6 and less than equal to 20")
    private String password;
    
    @NotBlank(message="Birth of date cannot be blank")
    private String birthOfDate;
}
