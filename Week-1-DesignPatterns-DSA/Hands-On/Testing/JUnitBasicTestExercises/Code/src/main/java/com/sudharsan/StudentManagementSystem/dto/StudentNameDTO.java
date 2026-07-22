package com.sudharsan.StudentManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor
@Getter
@Value // - makes fields immutable with final, will make fields as private, give the getters also and no setters.
public class StudentNameDTO {
//    private String  studentName;
//    private Integer studentAge;
    String  studentName;
    Integer studentAge;
}
