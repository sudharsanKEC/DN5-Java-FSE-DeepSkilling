package com.sudharsan.StudentManagementSystem.projection;


import org.springframework.beans.factory.annotation.Value;

public interface StudentDetailsProjection {

    @Value("#{target.studentName + ' (' + target.studentAge+')'}") // target represents the current entity's object.
    String getStudentDetails();
}
