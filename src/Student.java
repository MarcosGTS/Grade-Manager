public class Student {
    private String name;
    private Double[] grades = new Double[4];
    private Integer gradeCounter = 0;

    public Student(String _name) {
        this.name = _name;
    }

    public void addGrade(Double grade) {
        if (gradeCounter < 4) {
            grades[gradeCounter] = grade;
            gradeCounter++;
        }
    }

    public Double getBestAverage() {
        Double total = 0.0;
        Double lowestGrade = 0.0;

        for (Double grade : grades) {
            total += grade;
            lowestGrade = Math.min(grade, lowestGrade);
        }

        return (total - lowestGrade) / 3;
    }

    public Double getAverage() {
        return (grades[0] + grades[1] + grades[2]) / 3;
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
        System.out.print(String.format("%-10s",name));
        System.out.print(String.format("%10.1f", getAverage()));

        if (gradeCounter == 4)
            System.out.print(String.format("%10.1f", getBestAverage()));

        System.out.println();
    }
}
