package com.sudharsan.StudentManagementSystem;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvSources;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// Note: The testing method names should be more meaningful like shouldReturnGradeAFor95Marks(), shouldNotReturnGradeB().
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // - used to add priority for every methods using the annotation @Order()
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {


    @Mock
    private StudentRepository studentRepository;
    //StudentService studentService = new StudentService(null);
    @InjectMocks
    private StudentService studentService;
    /*
        Now Mockito creates something like
            StudentRepository repository = Mockito.mock(StudentRepository.class);
        before every test.
        This object created is by mockito not by spring.
        So hibernate and jPA is also not involved. Only Mockito is doing it.

    */

    @Test
    void shouldAddStudent(){
        Student student = Student.builder()
                .studentName("Bahubali")
                .studentAge(22)
                .build();
        String result = studentService.addStudent(student);
        System.out.println(result);
        assertEquals("Student added successfully", result);
    }

    @Test
    void shouldStubSaveMethod(){

        // Arrange
        Student student = Student.builder()
                .studentName("Bahubali")
                .studentAge(22)
                .build();

        // The below object will be returned by mockito when we call the studentRepository.save(student), which was configured below in the when().thenReturn()
        Student savedStudent = Student.builder()
                .studentId(1L)
                .studentName("Bahubali")
                .studentAge(22)
                .build();

        // The below is called stubbing, we are letting know mockito what to return instead of the default values for every type.
        // stub the mock
        // the when() is a static method.
        when(studentRepository.save(student))
                .thenReturn(savedStudent);

        // Act
        String result = studentService.addStudent(student);

        // Assert
        assertEquals("Student added successfully", result);
    }

    @Test
    void shouldReturnAllStudents() {

        // Arrange
        Student student1 = Student.builder()
                .studentId(1L)
                .studentName("Bahubali")
                .studentAge(22)
                .build();

        Student student2 = Student.builder()
                .studentId(2L)
                .studentName("Kattappa")
                .studentAge(55)
                .build();

        List<Student> students = List.of(student1, student2);

        // Stubbing
        when(studentRepository.findAll())
                .thenReturn(students);

        // Act
        List<Student> result = studentService.getStudents();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Bahubali", result.get(0).getStudentName());
        assertEquals("Kattappa", result.get(1).getStudentName());
    }

    @Test
    void shouldSaveStudent(){
        Student student = Student.builder()
                .studentName("Bahubali")
                .studentAge(22)
                .build();

        Student savedStudent = Student.builder()
                .studentId(1L)
                .studentName("Bahubali")
                .studentAge(22)
                .build();

        when(studentRepository.save(student))
                .thenReturn(savedStudent);


        studentService.addStudent(student);
        verify(studentRepository).save(student);
    }

    @BeforeAll // - this method runs only once before the test case methods starts
    static void beforeAll(){
        System.out.println("========== Starting StudentService Tests ==========");

    }

    @AfterAll
    static void afterAll(){
        System.out.println("========== All Tests Completed ============");
    }


    @Test // this annotation tells the Junit, that the below method is a test, without test it just ignores the method.
    @Order(1)
    public void shouldReturnGradeAFor95Marks(){
        String grade = studentService.calculateGrade(95);
        assertEquals("A",grade);
    }

    @Test
    @Order(2)
    public void shouldNotReturnGradeB(){
        assertNotEquals("B",studentService.calculateGrade(90));
    }

    @Test
    void shouldReturnPassStudent(){
        int mark = 95;
        // checks whether something is true
        assertTrue(mark >= 35);
    }

    @Test
    void shouldNotFail(){
        int mark = 90;
        // Opposite of assertTrue().
        assertFalse(mark < 35);
        System.out.println("Hi");
    }

    @Test
    void objectShouldBeNull(){
        Student student = null;
        // checks whether an object is null
        assertNull(student);
    }

    @Test
    void objectShouldExist(){
        Student student = new Student();
        assertNotNull(student);
    }


    @Test
    public void shouldThrowExceptionForNegativeMarks(){
        assertThrows(IllegalArgumentException.class, ()->studentService.calculateGrade(1000));
    }

    @Test
    void shouldNotThrowException(){
        assertDoesNotThrow(
                () -> studentService.calculateGrade(95)
        );
    }

    @Test
    void shouldReturnGradeCFor50Marks() {
        // Arrange

        int mark = 70;

        // Act
        String grade = studentService.calculateGrade(mark);

        // Assert
        assertEquals("C", grade);

    }

    //Let's test an exception.
    @Test
    void shouldThrowExceptionForInvalidMarks() {

        // Arrange
        StudentService studentService = new StudentService(null);

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> studentService.calculateGrade(120)
        );
    }




    @ParameterizedTest
    @ValueSource(ints = {90,91,92,93,94,95,96,97,98,99,100})
    void shouldReturnGradeA(int mark){
        assertEquals("A",studentService.calculateGrade(mark));
    }



    @ParameterizedTest
    @CsvSource({
            "95,A",
            "85,B",
            "75,C",
            "65,D",
            "45,F"
    })
    void shouldReturnCorrectGrade(int mark, String expectedGrade){
        assertEquals(expectedGrade, studentService.calculateGrade(mark));
    }

    @ParameterizedTest
    @ValueSource(ints = {-10,-1,101,150})
    void shouldThrowException(int mark){
        assertThrows(IllegalArgumentException.class,()->studentService.calculateGrade(mark));
    }
}
