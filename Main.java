import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeManager manager = new GradeManager();
        boolean running = true;

        while (running) {
            System.out.println("\n====================================");
            System.out.println("      STUDENT GRADE TRACKER");
            System.out.println("====================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Calculate Average");
            System.out.println("4. Highest Score");
            System.out.println("5. Lowest Score");
            System.out.println("6. Summary Report");
            System.out.println("7. Exit");
            System.out.print("\nEnter Choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                continue;
            }

            switch (choice) {
                case 1:
                    addStudentMenu(scanner, manager);
                    break;
                case 2:
                    manager.displayStudents();
                    break;
                case 3:
                    manager.calculateAverage();
                    break;
                case 4:
                    manager.getHighestScore();
                    break;
                case 5:
                    manager.getLowestScore();
                    break;
                case 6:
                    manager.showSummary();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option between 1 and 7.");
            }
        }
        scanner.close();
    }

    private static void addStudentMenu(Scanner scanner, GradeManager manager) {
        String id = "";
        while (true) {
            System.out.print("Enter Student ID: ");
            id = scanner.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("Error: Student ID cannot be empty.");
            } else {
                break;
            }
        }

        String name = "";
        while (true) {
            System.out.print("Enter Student Name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Error: Student Name cannot be empty.");
            } else {
                break;
            }
        }

        double grade = -1;
        while (true) {
            System.out.print("Enter Student Grade (0-100): ");
            try {
                grade = Double.parseDouble(scanner.nextLine().trim());
                if (grade < 0 || grade > 100) {
                    System.out.println("Error: Grade must be between 0 and 100.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid numeric input. Please enter a valid grade.");
            }
        }

        Student student = new Student(id, name, grade);
        manager.addStudent(student);
        System.out.println("Student added successfully!");
    }
}
