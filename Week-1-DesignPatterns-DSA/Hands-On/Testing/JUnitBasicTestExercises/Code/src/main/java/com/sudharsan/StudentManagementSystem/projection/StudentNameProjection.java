package com.sudharsan.StudentManagementSystem.projection;

// Spring implements this method as a class by infering the type in the repo method.
// The interface name can be whatever it is, whether it was ABC, BCD or StudentNameProjection, when the spring infers the type in the repo on List<StudentNameProjection> findAllProjectedBy();, it asks is it an entity class? Or an interface, if an interface it will try to implement it.
// It will see the getter method names in the StudentNameProjection and then finds the variables exist in the entity Student, for example for getStudentName() will translates to find the field studentName in Student class, if it exists then spring will start to implement the class completely. So the naming convention should be proper.
public interface StudentNameProjection {
    String getStudentName();
    String getStudentAge();
}
/*
So what actually tells Spring it's a projection?
This combination:
    public interface StudentInfo {
        String getStudentName();
        String getStudentAge();
    }
and
    List<StudentInfo> findAllProjectedBy(); in the repository class.
The return type is what triggers projection handling, not the interface's name or location.
*/

// Important:
// This is closed projection, that is, it tells hibernate to fetch those datas only that are specified from the interface
// Open projection is the one used with the @Value, where the entire data is fetched first and then modelled accordingly to our need. Refer the StudentDetailsProjection.java interface