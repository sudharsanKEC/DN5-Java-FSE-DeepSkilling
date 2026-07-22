package com.sudharsan.StudentManagementSystem;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        StudentServiceTest.class
}) // the @SelectClasses is for individual classes. For entire packages, we can use @SelectPackages("com.sudharsan.StudentManagementSystem")
public class StudentApplicationTestSuite {
}
