package test;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import main.Student;

public class StudentTests{
    
    @Test
    void addGradeTest() {
        Student newStudent = new Student("Marcos");
        newStudent.addGrade(5.3);
        newStudent.addGrade(7.0);
        newStudent.addGrade(8.5);
        newStudent.addGrade(7.5);
        
        Double[] expected = {5.3, 7.0, 8.5, 7.5};
        assertArrayEquals(expected, newStudent.getGrades());
    }
    
    
    @Test
    void getAverageTest() {
        Student newStudent = new Student("Marcos");
        newStudent.addGrade(6.0);
        newStudent.addGrade(7.0);
        newStudent.addGrade(8.0);

        assertEquals(7.0, newStudent.getAverage());
    }

    @Test
    void getBestAverageTest() {
        Student newStudent = new Student("Marcos");
        newStudent.addGrade(6.0);
        newStudent.addGrade(5.0);
        newStudent.addGrade(7.0);
        newStudent.addGrade(8.0);

        System.out.println(newStudent.getGrades());
        assertEquals(7.0, newStudent.getBestAverage());
    }
}
