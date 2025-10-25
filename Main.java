

import university.services.*;
import university.models.*;
import university.utils.Console;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the University Management System (Huge Sample Project)");

        UniversityService us = new UniversityService();

        // Generate bulk data
        System.out.println("Generating bulk data... (this may take a few moments)");
        us.loadBulkData(250, 40, 80, 8); // 250 students, 40 teachers, 80 courses, 8 departments
        System.out.println("Data generation finished.");

        ReportService rs = new ReportService(us);

        // Simple CLI loop
        while (true) {
            System.out.println("\nMenu:\n" +
                    "1) Show top students\n" +
                    "2) Show department summaries\n" +
                    "3) Show a student by ID\n" +
                    "4) Show course by code\n" +
                    "5) Exit");
            int choice = Console.readInt("Choose: ");
            switch (choice) {
                case 1:
                    rs.printTopStudents(10);
                    break;
                case 2:
                    rs.departmentSummary();
                    break;
                case 3:
                    String sid = Console.readLine("Enter student id (e.g. S...): ");
                    Student s = us.getStudent(sid);
                    if (s == null) System.out.println("Student not found.");
                    else System.out.println(s + "\nEnrollments: " + s.getEnrollments().size());
                    break;
                case 4:
                    String code = Console.readLine("Enter course code (e.g. C100): ");
                    Course c = us.getCourse(code);
                    if (c == null) System.out.println("Course not found.");
                    else System.out.println(c + "\nAssignments: " + c.getAssignments().size());
                    break;
                case 5:
                    System.out.println("Bye!");
                    System.exit(0);
                default:
                    System.out.println("Unknown option.");
            }
        }
    }
}
