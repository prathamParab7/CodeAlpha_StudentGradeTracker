public class Student {
    private String studentId;
    private String studentName;
    private double grade;

    public Student(String studentId, String studentName, double grade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getFormattedGrade() {
        if (grade == (long) grade) {
            return String.format("%d", (long) grade);
        } else {
            return String.format("%s", grade);
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Grade: %s", studentId, studentName, getFormattedGrade());
    }
}
