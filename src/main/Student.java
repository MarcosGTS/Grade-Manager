package main;
public class Student {
    private String name;
    private Double[] grades = new Double[4];
    private Integer gradeCounter = 0;

    public Student(String _name) {
        this.name = _name;
    }

    public Boolean addGrade(Double grade) {

        // Grade must be in the range 0 - 10
        if (grade < 0 || grade > 10) return false;

        if (gradeCounter < 4) {
            grades[gradeCounter] = grade;
            gradeCounter++;
            
            return true;
        }

        return false;
    }

    public Double getBestAverage() {
        Double total = 0.0;
        Double lowestGrade = grades[0];
        Double average = 0.0;

        for (Double grade : grades) {
            total += grade;
            lowestGrade = Math.min(grade, lowestGrade);
        }

        average = (total - lowestGrade) / 3;
        return (double) Math.round(average * 10) / 10; 
    }

    public Double getAverage() {
        Double average = (grades[0] + grades[1] + grades[2]) / 3;
        return (double) Math.round(average * 10) / 10.0; 
    }

    public Double[] getGrades() {
        Double[] gradesCopy = new Double[4];

        for (int i = 0; i < 4; ++i)
            gradesCopy[i] = grades[i];

        return gradesCopy;
    }

    public String getName() {
        return name;
    } 

    public void showStatus() {
        System.out.print(String.format("%-10s", name));
        System.out.print(String.format("%10.1f", getAverage()));

        if (gradeCounter == 4)
            System.out.print(String.format("%10.1f", getBestAverage()));

        System.out.println();
    }
}
