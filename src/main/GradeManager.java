package main;
import java.util.Scanner;

public class GradeManager {
    Scanner scan;
    Student[] students = new Student[10];
    Integer studentCounter = 0;

    public GradeManager(Scanner _scan) {
        scan = _scan;
    }

    public Boolean addStudent(Student student) {
        if (studentCounter < 10) {
            students[studentCounter] = student;
            studentCounter++;
            
            return true;
        }

        return false;
    }

    private Double getGrade(String msg) {
        System.out.print(msg);
        return scan.nextDouble();
    }

    public Boolean registerStudent() {
        System.out.print("[Student Name]: ");
        String name = scan.next();
        scan.nextLine();

        if (name.isEmpty()) return false;

        Student newStudent = new Student(name);
        addStudent(newStudent);
        registerGrade(newStudent);

        return true;
    }

    public void registerGrade(Student student) {
        for (int i = 0; i < 3; ++i) {
            String msg = String.format("[Grade %d]: ", i);
            Double grade = getGrade(msg);

            student.addGrade(grade);
        }

        if (student.getAverage() < 7) {
            Double grade = getGrade("[Grade 4]: ");

            student.addGrade(grade);
        }
    } 

    public void showStudents() {
        System.out.println();
        System.out.println(String.format("%-10s%10s%10s", "NAME", "AVG.", "NEW AVG."));

        for (Student student : students) {
            if (student != null) student.showStatus();
        }

        System.out.println();
    }
}