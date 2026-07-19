import java.util.ArrayList;

public class GradeManager {
    private ArrayList<Student> students;

    public GradeManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("------------------------------------------------------");
        System.out.printf("%-10s%-25s%-10s%n", "ID", "Name", "Grade");
        System.out.println("------------------------------------------------------");
        for (Student s : students) {
            System.out.printf("%-10s%-25s%-10s%n", s.getStudentId(), s.getStudentName(), s.getFormattedGrade());
        }
        System.out.println("------------------------------------------------------");
    }

    public void calculateAverage() {
        if (students.isEmpty()) {
            System.out.println("No students available to calculate average.");
            return;
        }
        double total = 0;
        for (Student s : students) {
            total += s.getGrade();
        }
        double average = total / students.size();
        System.out.printf("Average Grade : %.2f%n", average);
    }

    public void getHighestScore() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        Student highest = students.get(0);
        for (Student s : students) {
            if (s.getGrade() > highest.getGrade()) {
                highest = s;
            }
        }
        System.out.println("Highest Score : " + highest.getFormattedGrade());
        System.out.println("Student : " + highest.getStudentName());
    }

    public void getLowestScore() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        Student lowest = students.get(0);
        for (Student s : students) {
            if (s.getGrade() < lowest.getGrade()) {
                lowest = s;
            }
        }
        System.out.println("Lowest Score : " + lowest.getFormattedGrade());
        System.out.println("Student : " + lowest.getStudentName());
    }

    public void showSummary() {
        if (students.isEmpty()) {
            System.out.println("No data for summary report.");
            return;
        }
        
        System.out.println("====================================");
        System.out.println("SUMMARY REPORT");
        System.out.println("====================================");
        System.out.println("Total Students : " + students.size());
        
        Student highest = students.get(0);
        Student lowest = students.get(0);
        double total = 0;
        
        for (Student s : students) {
            if (s.getGrade() > highest.getGrade()) highest = s;
            if (s.getGrade() < lowest.getGrade()) lowest = s;
            total += s.getGrade();
        }
        
        double average = total / students.size();
        
        System.out.println("Highest Grade : " + highest.getFormattedGrade());
        System.out.println("Lowest Grade : " + lowest.getFormattedGrade());
        System.out.printf("Average Grade : %.2f%n", average);
        System.out.println("====================================");
        System.out.println();
        System.out.println("Student List");
        System.out.println();
        System.out.printf("%-10s%-25s%-10s%n", "ID", "Name", "Grade");
        for (Student s : students) {
            System.out.printf("%-10s%-25s%-10s%n", s.getStudentId(), s.getStudentName(), s.getFormattedGrade());
        }
    }
}
