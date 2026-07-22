package com.sudharsan.StudentManagementSystem;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvSources;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

// Note: The testing method names should be more meaningful like shouldReturnGradeAFor95Marks(), shouldNotReturnGradeB().
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentServiceTest {

    //StudentService studentService = new StudentService(null);
    StudentService studentService;

    @BeforeEach // - runs before every testing method marked with @Test, now each test will start with a fresh state, one test should never affect another. Every test will automatically receives a new object of the Student.
    void setup(){
        System.out.println("Creating StudentService...");
        studentService = new StudentService(null);
    }

    @AfterEach // - runs after every testing method
    void cleanup(){
        System.out.println("Cleaning after test...");
        studentService = null;
    }

    @BeforeAll // - this method runs only once before the test case methods starts
    static void beforeAll(){
        System.out.println("========== Starting StudentService Tests ==========");

    }

    @AfterAll
    static void afterAll(){
        System.out.println("========== All Tests Completed ============");
    }
    // @BeforeEach - Very commonly used.
    // @AfterEach -  Sometimes
    // @BeforeAll -  Occasionally
    // @AfterAll -   Occasionally


    @Test // this annotation tells the Junit, that the below method is a test, without test it just ignores the method.
    @Order(1)
    public void shouldReturnGradeAFor95Marks(){
        String grade = studentService.calculateGrade(95);
        //What is an Assertion?     An assertion is simply a statement that verifies whether the actual result matches the expected result.
        // that the below method tests whether the given and the expected ones are equal.
        assertEquals("A",grade);
    }

    @Test
    @Order(2)
    public void shouldNotReturnGradeB(){
        // used to check whether two values are not equal. If not equal then test case gets passed, if equal then test case gets failed.
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

    // The below is the AAA(Arrange Act Assert) pattern usually followed in professional unit test cases.
    @Test
    void shouldReturnGradeCFor50Marks() {
        // Arrange
        StudentService studentService = new StudentService(null);
        int mark = 70;

        // Act
        String grade = studentService.calculateGrade(mark);

        // Assert
        assertEquals("C", grade);

        /*
            Note:
                Arrange:
                       Purpose: Prepare everything needed for the test.
                       This includes: Creating objects, Initializing variables, Setting up test data, Configuring mocks (later with Mockito)
                Act:
                        Purpose: Execute the method you're testing.
                        Example:
                            String grade = studentService.calculateGrade(mark);
                        We're calling the method under test.
                        This is the Act phase.
                        Notice that there should usually be only one action in a unit test.
                Assert:
                        Purpose: Verify the result.
                        Example:
                            assertEquals("A", grade);
                        We're checking whether the returned grade is correct.

This is the Assert phase.
        */
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
    //    Here the Act and Assert are combined because the action itself is what we're asserting.


    // Parameterized tests - it is used to remove the duplicated code.
    @ParameterizedTest
    @ValueSource(ints = {90,91,92,93,94,95,96,97,98,99,100})
    // Now this method will run for 11 times for the every numbers in the above. So there will 11 test cases running for this.
    void shouldReturnGradeA(int mark){
        assertEquals("A",studentService.calculateGrade(mark));
    }
    // So the parameterized test helps us to prevent code repetition.

    // For different marks and different grades.
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


/*
Why AAA?
    Why use AAA?
    Imagine a test without it:
    @Test
    void test(){
        StudentService service = new StudentService(null);
        assertEquals(
            "A",
            service.calculateGrade(95)
        );
    }
It works.
    But as tests become larger, it becomes difficult to see:
        What was prepared?
        What was executed?
        What was verified?
    Now compare it with:
        @Test
        void shouldReturnGradeAFor95Marks(){
            // Arrange
            StudentService service = new StudentService(null);
            int mark = 95;
            // Act
            String grade = service.calculateGrade(mark);
            // Assert
            assertEquals("A", grade);
        }
    The second version is much easier to understand, especially for someone reading your code months later.
*/