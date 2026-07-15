package com.sudharsan.StudentManagementSystem;

import com.sudharsan.StudentManagementSystem.dto.StudentNameDTO;
import com.sudharsan.StudentManagementSystem.projection.StudentDetailsProjection;
import com.sudharsan.StudentManagementSystem.projection.StudentNameProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public String addStudent(Student newStudent){
        studentRepository.save(newStudent);
        return "Student added successfully";
    }

    public List<Student> getStudents(){
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @Transactional
    public String deleteStudentById(Long id){
        Long isDeleted = studentRepository.deleteStudentByStudentId(id);
        if(isDeleted == 0) return "Student with Id: "+id+" Not found.";
        return "Student with Id: "+id+" deleted successfully.";
    }

    public Map<String, Object> updateStudentById(Long id, Student newStudentData){
        Optional<Student> studentExists = studentRepository.findStudentByStudentId(id);
        Student oldStudentData;
        Map<String, Object> response = new HashMap<>();
        if(studentExists.isEmpty()){
            response.put("severMessage","Student doesn't found with that ID.");
            response.put("status", HttpStatus.OK.value());
            return response;
        }
        oldStudentData = studentExists.get();
        if(newStudentData.getStudentAge() != null){
            oldStudentData.setStudentAge(newStudentData.getStudentAge());
        }
        if(newStudentData.getStudentName() != null){
            oldStudentData.setStudentName(newStudentData.getStudentName());
        }
        studentRepository.save(oldStudentData);
        response.put("serverMessage","Student updated successfully");
        response.put("status", HttpStatus.OK.value());
        Map<String,Object> newStudent = new LinkedHashMap<>();
        newStudent.put("id",oldStudentData.getStudentId());
        newStudent.put("name",oldStudentData.getStudentName());
        newStudent.put("age",oldStudentData.getStudentAge());
        response.put("updated details",newStudent);
        return response;
    }

    @Transactional
    public Long updateAllStudentAgePlusOne(){
        return studentRepository.incrementStudentAgeByOne();
    }

    public void justCallMe(){
        Student student1 = studentRepository.findByStudentId(4);
        System.out.println(student1.getStudentName()+" and "+student1.getStudentAge());

        Student student2 = studentRepository.findByStudentNameAndStudentAge("Lionel Messi", 34);
        System.out.println(student2.getStudentName()+" and "+student2.getStudentAge());

        List<Student> student3 = studentRepository.findByStudentAgeLessThanEqual(30);
        System.out.println(student3);
        /*
        Other important and frequently used methods:
            Greater Than
                findByStudentAgeGreaterThan(Integer age)
            Between
                findByStudentAgeBetween(18,25)
            Like
                findByStudentNameLike("%Sud%")
            Containing
                findByStudentNameContaining("Sud") -> SQL   LIKE '%Sud%'
            StartsWith
                findByStudentNameStartingWith("Sud")
            EndsWith
                findByStudentNameEndingWith("han")
            Ignore Case
                findByStudentNameIgnoreCase(String name)
            In
                findByStudentAgeIn(List<Integer> ages)
Not
findByStudentNameNot(String name)
Is Null
findByStudentNameIsNull()
Is Not Null
findByStudentNameIsNotNull()
Order By
findByStudentAgeOrderByStudentNameAsc(Integer age)


        */
    }

    // Pagination with Page
//    public Page<Student> getStudentsPage(int page, int size){
//        System.out.println("Called");
//        return studentRepository.findAll(PageRequest.of(page,size));
//    }

    // Pagination with Pageable
    public Page<Student> getStudentsPage(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> pages = studentRepository.findAll(pageable);
        return pages;
    }

    public Page<Student> getStudentPageBySort(int page, int size){
        return studentRepository.findAll(PageRequest.of(page, size, Sort.by("studentAge").descending()));
    }

    public Page<Student> getStudentPageBySortByField(int page, int size, String field, String direction){
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(field).descending() : Sort.by(field).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return studentRepository.findAll(pageable);

    }

    // Interface projection
    public List<StudentNameProjection> getStudentNames(){
        return studentRepository.findAllProjectedBy();
    }

    // Class based projection
    public List<StudentNameDTO> getStudentNamesDTO(){
        return studentRepository.getStudentNames();
    }

    // Projection along with the @Value
    public List<StudentDetailsProjection> getStudentDetails(){
        return studentRepository.findAllBy();
    }

    public Student getStudentById(Long id){
        return studentRepository.findStudentByStudentId(id)
                .orElseThrow(()->new RuntimeException("Student not found."));
    }
    

}
/*

Page<Student>?

Think of it as a wrapper object.

Inside it, Spring stores:

The list of students for the current page.
Total number of students.
Total number of pages.
Current page number.
Page size.
Whether it is the first page.
Whether it is the last page.
And other pagination information.

You can imagine it like this (not the real source code):

interface Page<T> {

    List<T> content;

    int totalPages;

    long totalElements;

    int pageNumber;

    int pageSize;

    boolean first;

    boolean last;

    ...
}

So when you write

Page<Student> pages =
        studentRepository.findAll(pageable);

Spring creates something conceptually like:

Page<Student>

{
    content = List<Student>,
    totalPages = 7,
    totalElements = 19,
    pageNumber = 2,
    pageSize = 3,
    ...
}

Notice

The students are inside the Page.
The content is actually List<Student> inside the Page.
Can we get only the list?
Yes.
Page has a method:
    pages.getContent();
Example
    Page<Student> pages =
            studentRepository.findAll(pageable);
    List<Student> students =
            pages.getContent();
*/
