package com.sudharsan.StudentManagementSystem;

import com.sudharsan.StudentManagementSystem.dto.StudentNameDTO;
import com.sudharsan.StudentManagementSystem.projection.StudentDetailsProjection;
import com.sudharsan.StudentManagementSystem.projection.StudentNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public Long deleteStudentByStudentId(Long id);
    public Optional<Student> findStudentByStudentId(Long id);

    @Modifying
    @Query(
            value = "UPDATE student SET student_age =  student_age+1",
            nativeQuery = true
    )
    public Long incrementStudentAgeByOne();

    Student findByStudentId(Integer id);
    Student findByStudentNameAndStudentAge(String name, int age);
    List<Student> findByStudentAgeLessThanEqual(int age);

    // Interface based Projection
    List<StudentNameProjection> findAllProjectedBy();
    // Same like the above we can pass argument and get data based on the given argument
    // List<StudentNameProjection> findByStudentName(String name); // it returns studentName and studentAge of the given student

    // Class based Projection using DTO
    //
    @Query("""
                SELECT new com.sudharsan.StudentManagementSystem.dto.StudentNameDTO(
                           s.studentName, s.studentAge
                           ) FROM Student s
           """)
    // in the above we have used the JPQL constructor, in the above we are saying jpql to retrieve studentName and studentAge, indeed it tells hibernate: for every row, create a new StudentNameDTO
    // the constructor used above is the constructor expression
    List<StudentNameDTO> getStudentNames();

    List<StudentDetailsProjection> findAllBy();
    Student getStudentByStudentId(Long id);
}
