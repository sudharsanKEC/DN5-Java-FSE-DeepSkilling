package com.sudharsan.StudentManagementSystem;

import com.sudharsan.StudentManagementSystem.dto.StudentNameDTO;
import com.sudharsan.StudentManagementSystem.projection.StudentDetailsProjection;
import com.sudharsan.StudentManagementSystem.projection.StudentNameProjection;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")
@Slf4j
public class StudentController {

    private StudentService studentService;
//    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Map<String, Object>> addStudent(@RequestBody Student student){
        log.info("Received request to add student: {}",student.getStudentName());
        String serverMessage = studentService.addStudent(student);
        Map<String, Object> hm = new HashMap<>();
        hm.put("ServerMessage",serverMessage);
        hm.put("status", HttpStatus.OK.value());
        return ResponseEntity.ok(hm);
    }

    @GetMapping("/getStudent")
    public List<Student> getStudents(){
        List<Student> students = studentService.getStudents();
        log.info("Received request to fetch all students");
        return students;
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public ResponseEntity<Map<String,Object>> deleteStudentById(@PathVariable Long id){
        String serverMessage = studentService.deleteStudentById(id);
        Map<String, Object> hm = new HashMap<>();
        hm.put("serverMessage",serverMessage);
        hm.put("status",HttpStatus.OK.value());
        return ResponseEntity.ok(hm);
    }

    @PutMapping("/updateStudentById/{id}")
    public ResponseEntity<Map<String,Object>> updateStudentById(@PathVariable Long id, @RequestBody Student student){
        Map<String,Object> response = studentService.updateStudentById(id,student);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/updateAllStudentAgePlusOne")
    public Long updateAllStudentAgePlusOne(){
        return studentService.updateAllStudentAgePlusOne();
    }

    @GetMapping("/callMe")
    public void justCallMe(){
        studentService.justCallMe();
    }

    @GetMapping("/pageMe")
    public Page<Student> pageMe(@RequestParam int page, @RequestParam int size){
        System.out.println("Called");
        return studentService.getStudentsPage(page, size);
    }

    @GetMapping("/pageMeAndSort")
    public Page<Student> pageMeAndSort(@RequestParam int page, @RequestParam int size){
        return studentService.getStudentPageBySort(page, size);
    }

    @GetMapping("/pageMeAndSortByField")
    public Page<Student> pageMeAndSortByField(@RequestParam int page, @RequestParam int size, @RequestParam String field, @RequestParam String direction){
        return studentService.getStudentPageBySortByField(page, size, field, direction);
    }

    // Interface based projection
    @GetMapping("/studentNames")
    public List<StudentNameProjection> getStudentNames(){

        return studentService.getStudentNames();

    }

    @GetMapping("/studentNamesDTO")
    public List<StudentNameDTO> getStudentNamesDTO(){

        return studentService.getStudentNamesDTO();

    }

    @GetMapping("/studentDetails")
    public List<StudentDetailsProjection> getStudentDetails(){
        return studentService.getStudentDetails();
    }

    @GetMapping("/getStudentByIdWithHateoas/{id}")
    public ResponseEntity<EntityModel<Student>> getStudentByIdWithHateoas(@PathVariable Long id){
        Student student = studentService.getStudentById(id);
        EntityModel<Student> model = EntityModel.of(student);

        model.add(
                linkTo(methodOn(StudentController.class)
                        .getStudentByIdWithHateoas(id))
                        .withSelfRel()
        );

        model.add(
                linkTo(methodOn(StudentController.class)
                        .getStudents())
                        .withRel("allStudents")
        );

        model.add(
                linkTo(methodOn(StudentController.class)
                        .deleteStudentById(id))
                        .withRel("deleteStudent")
        );

        model.add(
                linkTo(methodOn(StudentController.class)
                        .pageMe(0,5))
                        .withRel("firstPage")
        );

        return ResponseEntity.ok(model);
    }

    @GetMapping("/grade")
    public String getGrade(@RequestParam Integer mark){
        return studentService.calculateGrade(mark);
    }
}
