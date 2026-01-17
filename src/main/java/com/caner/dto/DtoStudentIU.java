package com.caner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
    private String firstName;
    private String lastName;
    private Integer age;
    private String password;
    private String birthOfDate;
}
